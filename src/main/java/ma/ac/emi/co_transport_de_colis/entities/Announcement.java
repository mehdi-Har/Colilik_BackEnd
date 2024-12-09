package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "announcements")
public class Announcement {
    @Id
    private String idAnnouncement;
    private String customerId;
    private String description;
    private LocalDateTime pickUpTime;
    private String dropUpFrom;
    private String dropTo;
    private LocalDateTime deliveryTime;
    private double propositionCustomer;
    @DBRef
    private List<Item> items= new ArrayList<>();

    public Announcement(String idAnnouncement, String customerId, String description, LocalDateTime pickUpTime, String dropUpFrom, String dropTo, LocalDateTime deliveryTime, double propositionCustomer) {
        this.idAnnouncement = idAnnouncement;
        this.customerId = customerId;
        this.description = description;
        this.pickUpTime = pickUpTime;
        this.dropUpFrom = dropUpFrom;
        this.dropTo = dropTo;
        this.deliveryTime = deliveryTime;
        this.propositionCustomer = propositionCustomer;
    }
    public Announcement(){}

    public String getIdAnnouncement() {
        return idAnnouncement;
    }

    public void setIdAnnouncement(String idAnnouncement) {
        this.idAnnouncement = idAnnouncement;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalDateTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getDropUpFrom() {
        return dropUpFrom;
    }

    public void setDropUpFrom(String dropUpFrom) {
        this.dropUpFrom = dropUpFrom;
    }

    public String getDropTo() {
        return dropTo;
    }

    public void setDropTo(String dropTo) {
        this.dropTo = dropTo;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public double getPropositionCustomer() {
        return propositionCustomer;
    }

    public void setPropositionCustomer(double propositionCustomer) {
        this.propositionCustomer = propositionCustomer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "idAnnouncement='" + idAnnouncement + '\'' +
                ", customerId='" + customerId + '\'' +
                ", description='" + description + '\'' +
                ", pickUpTime=" + pickUpTime +
                ", dropUpFrom='" + dropUpFrom + '\'' +
                ", dropTo='" + dropTo + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", propositionCustomer=" + propositionCustomer +
                '}';
    }
}