package idariam.PublisherSubscriber.service;


import idariam.PublisherSubscriber.model.PurchaseModel;
import idariam.PublisherSubscriber.model.SampleModel;
import idariam.PublisherSubscriber.model.SubscriptionModel;
import idariam.PublisherSubscriber.repository.ClientRepositoryPurchase;
import idariam.PublisherSubscriber.repository.ClientRepositorySubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //marks class as service
public class SubscriberService {
    @Autowired
    private ClientRepositoryPurchase clientRepositoryPurchase;
    @Autowired
    private ClientRepositorySubscription clientRepositorySubscription;


    //create entity in DB according to the action
    public void createEntity(SampleModel sampleModel) {

        if (sampleModel.getAction().toLowerCase().equals("purchase")) {
            PurchaseModel pmodel =new PurchaseModel(sampleModel.getMsisdn(), sampleModel.getTimestamp());
            clientRepositoryPurchase.save(pmodel);

        } else {
            SubscriptionModel smodel = new SubscriptionModel(sampleModel.getMsisdn(), sampleModel.getTimestamp());
            clientRepositorySubscription.save(smodel);


        }

    }

}
