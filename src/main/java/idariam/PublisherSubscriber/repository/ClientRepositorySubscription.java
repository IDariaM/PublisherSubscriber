package idariam.PublisherSubscriber.repository;

import idariam.PublisherSubscriber.model.SubscriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositorySubscription extends JpaRepository<SubscriptionModel, Integer>  {
}