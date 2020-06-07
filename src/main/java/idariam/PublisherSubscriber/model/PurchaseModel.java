package idariam.PublisherSubscriber.model;

import javax.persistence.*;

@Entity
@Table(name = "purchase")
public class PurchaseModel {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "clientsIdSeq", sequenceName = "clients_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientsIdSeq")
    private Integer id;
    @Column(name="msisdn")
    private String msisdn;

    @Column (name = "timestamp")
    private String timestamp;

    public PurchaseModel(String msisdn, String timestamp) {
        this.msisdn = msisdn;
        this.timestamp = timestamp;
    }

    public PurchaseModel() {
    }
}
