package idariam.PublisherSubscriber.controller;


import idariam.PublisherSubscriber.model.SampleModel;
import idariam.PublisherSubscriber.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //Marks class as controller and shows that custom xml/json object can be returned in this class
public class SubscribeController {
    private final SubscriberService subscriberService;

    @Autowired //shows the necessity to inject the dependence here
    public SubscribeController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }


    @PostMapping(value = "/subscriptions")//Marks method as receiver of post requests
    //receive request and make service to create a new entity
    public void putNewEntity(@RequestBody SampleModel sampleModel) {

        subscriberService.createEntity(sampleModel);

    }

}
