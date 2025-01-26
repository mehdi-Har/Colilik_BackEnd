package ma.ac.emi.co_transport_de_colis.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ma.ac.emi.co_transport_de_colis.Enums.EnumStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "announcements")
public class Announcement {
    @Id
    private String announcementId;

    private String customerId;
    private LocalDateTime pickUpTime;
    private double longDest;
    private double latDest;
    private double latDepart;
    private double longDepart;
    private String destination;
    private String depart;
    private LocalDateTime deliveryTime;
    private LocalDate date;
    private String senderName;
    private String phoneNumber;
    private String alternativeSenderPhoneNumber;
    private String receiverName;
    private String receiverPhoneNumber;
    private String alternativeReceiverPhoneNumber;
    @DBRef
    private List<Item> items= new ArrayList<>();

    public Announcement(String customerId, LocalDateTime pickUpTime, double longDest, double latDest, double latDepart, double longDepart, String destination, String depart, LocalDateTime deliveryTime, LocalDate date, String senderName, String phoneNumber, String alternativeSenderPhoneNumber, String receiverName, String receiverPhoneNumber, String alternativeReceiverPhoneNumber, List<Item> items) {
        this.customerId = customerId;
        this.pickUpTime = pickUpTime;
        this.longDest = longDest;
        this.latDest = latDest;
        this.latDepart = latDepart;
        this.longDepart = longDepart;
        this.destination = destination;
        this.depart = depart;
        this.deliveryTime = deliveryTime;
        this.date = date;
        this.senderName = senderName;
        this.phoneNumber = phoneNumber;
        this.alternativeSenderPhoneNumber = alternativeSenderPhoneNumber;
        this.receiverName = receiverName;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.alternativeReceiverPhoneNumber = alternativeReceiverPhoneNumber;
        this.items = items;
    }

    public Announcement(){}

    public String getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getDestination() {
        return destination;
    }

    public String getDepart() {
        return depart;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAlternativeSenderPhoneNumber() {
        return alternativeSenderPhoneNumber;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public String getAlternativeReceiverPhoneNumber() {
        return alternativeReceiverPhoneNumber;
    }



    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAlternativeSenderPhoneNumber(String alternativeSenderPhoneNumber) {
        this.alternativeSenderPhoneNumber = alternativeSenderPhoneNumber;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public void setAlternativeReceiverPhoneNumber(String alternativeReceiverPhoneNumber) {
        this.alternativeReceiverPhoneNumber = alternativeReceiverPhoneNumber;
    }


}