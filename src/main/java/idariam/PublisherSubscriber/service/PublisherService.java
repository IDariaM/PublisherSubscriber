package idariam.PublisherSubscriber.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PublisherService {
    private JSONObject jobject = new JSONObject();
    private ArrayList<String> actions = new ArrayList<>(); //ArrayList with actions' names
    private String aimURL = "http://localhost:8080/subscriptions";
    private OutputStream outputStream;
    HttpURLConnection urlConnection;

    //create JSON obj for sending
    public void createObj() {
        try {
            jobject.put("msisdn", msisdnCreation());
            jobject.put("action", chooseAction());
            jobject.put("timestamp", String.valueOf(new Timestamp(System.currentTimeMillis()).getTime()));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //send POST request
    public void sendRequest() {
        try {
            //set the connection, create json, send json
            URL url = new URL(aimURL);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            createObj();
            byte[] out = jobject.toString().getBytes(StandardCharsets.UTF_8);
            urlConnection.setFixedLengthStreamingMode(out.length);
            urlConnection.connect();
            outputStream = urlConnection.getOutputStream();
            outputStream.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //shut down the stream
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //method for msisdn generation
    public String msisdnCreation() {
        StringBuilder result = new StringBuilder();
        //arraylist with nums 0-9
        List<Integer> nums = IntStream.range(0, 9).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(nums);
        for (int i : nums) {
            result.append(i);
        }
        return result.toString();
    }

    //choose random action
    public String chooseAction() {
        actions.add("PURCHASE");
        actions.add("SUBSCRIPTION");
        Collections.shuffle(actions);
        return actions.get(0);
    }


}

