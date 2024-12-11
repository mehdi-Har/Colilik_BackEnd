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
    private String announcementId;
    @DBRef
    private Customer customer;
    private String description;
    private LocalDateTime pickUpTime;
    private String dropUpFrom;
    private String dropTo;
    private LocalDateTime deliveryTime;
    private boolean status= false;
    private List<DriverProposal> driverProposals;
    @DBRef
    private List<Item> items= new ArrayList<>();

    public Announcement(Customer customer, String description, LocalDateTime pickUpTime, String dropUpFrom, String dropTo, LocalDateTime deliveryTime) {
        this.setCustomer(customer);
        this.setDescription(description);
        this.setPickUpTime(pickUpTime);
        this.setDropUpFrom(dropUpFrom);
        this.setDropTo(dropTo);
        this.setDeliveryTime(deliveryTime);
    }
    public Announcement(){}

    public String getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<DriverProposal> getDriverProposals() {
        return driverProposals;
    }

    public void setDriverProposals(List<DriverProposal> driverProposals) {
        this.driverProposals = driverProposals;
    }
    public void addDriverProposal(DriverProposal driverProposal) {
        driverProposals.add(driverProposal);
    }

    public void removeDrivarProposal(DriverProposal driverProposal) {
        driverProposals.remove(driverProposal);
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
}