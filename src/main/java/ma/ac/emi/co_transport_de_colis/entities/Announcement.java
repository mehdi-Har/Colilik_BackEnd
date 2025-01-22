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
    private User customer;
    private String description;
    private LocalDateTime pickUpTime;
    private double longDest;
    private double latDest;
    private double latDepart;
    private double longDepart;
    private LocalDateTime deliveryTime;
    private boolean status= false;
    @DBRef
    private List<Item> items= new ArrayList<>();

    public Announcement(String announcementId, User customer, String description, LocalDateTime pickUpTime, double longDest, double latDest, double latDepart, double longDepart, LocalDateTime deliveryTime, boolean status, List<Item> items) {
        this.announcementId = announcementId;
        this.customer = customer;
        this.description = description;
        this.pickUpTime = pickUpTime;
        this.longDest = longDest;
        this.latDest = latDest;
        this.latDepart = latDepart;
        this.longDepart = longDepart;
        this.deliveryTime = deliveryTime;
        this.status = status;
        this.items = items;
    }

    public Announcement(){}

    public String getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
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

    public double getLongDest() {
        return longDest;
    }

    public void setLongDest(double longDest) {
        this.longDest = longDest;
    }

    public double getLatDest() {
        return latDest;
    }

    public void setLatDest(double latDest) {
        this.latDest = latDest;
    }

    public double getLatDepart() {
        return latDepart;
    }

    public void setLatDepart(double latDepart) {
        this.latDepart = latDepart;
    }

    public double getLongDepart() {
        return longDepart;
    }

    public void setLongDepart(double longDepart) {
        this.longDepart = longDepart;
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