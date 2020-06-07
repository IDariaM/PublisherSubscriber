package idariam.PublisherSubscriber.repository;

import idariam.PublisherSubscriber.model.PurchaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositoryPurchase extends JpaRepository<PurchaseModel, Integer>  {
}