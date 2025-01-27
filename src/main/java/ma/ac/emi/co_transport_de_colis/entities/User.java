package ma.ac.emi.co_transport_de_colis.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class User extends Account {
    private Double rating;
    private String numeroCIN;
    private String imageProfil;
    private String imageCIN;
    private double walletBalance;
    private LocalDateTime pickUpTime;
    private int totalOrders;
    private int totalDeliveries;
    private double LongDest;
    private double latDest;
    private double LongDepart;
    private double latDepart;
    private boolean isDriver = false;
    private LocalDateTime deliveryTime;
    @JsonBackReference
    @DBRef
    private List<Order> orders = new ArrayList<>();

    @DBRef
    private List<Announcement> announcements= new ArrayList<>();




    public User(String clerkId, String fullName, String userEmail,String numeroCIN, String imageProfil, String imageCIN) {
        super(clerkId, fullName, userEmail);
        this.rating = 0.0;
        this.numeroCIN = numeroCIN;
        this.imageProfil = imageProfil;
        this.imageCIN = imageCIN;
        this.walletBalance = 0.0;
        this.totalOrders = 0;
        this.totalDeliveries = 0;

    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public int getTotalDeliveries() {
        return totalDeliveries;
    }

    public void setTotalDeliveries(int totalDeliveries) {
        this.totalDeliveries = totalDeliveries;
    }

    public double getLongDest() {
        return LongDest;
    }

    public void setLongDest(double longDest) {
        LongDest = longDest;
    }

    public double getLatDest() {
        return latDest;
    }

    public void setLatDest(double latDest) {
        this.latDest = latDest;
    }

    public double getLongDepart() {
        return LongDepart;
    }

    public void setLongDepart(double longDepart) {
        LongDepart = longDepart;
    }

    public double getLatDepart() {
        return latDepart;
    }

    public void setLatDepart(double latDepart) {
        this.latDepart = latDepart;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
    }

    public User() {}

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getNumeroCIN() {
        return numeroCIN;
    }

    public void setNumeroCIN(String numeroCIN) {
        this.numeroCIN = numeroCIN;
    }

    public String getImageCIN() {
        return imageCIN;
    }

    public void setImageCIN(String imageCIN) {
        this.imageCIN = imageCIN;
    }

    public String getImageProfil() {
        return imageProfil;
    }

    public void setImageProfil(String imageProfil) {
        this.imageProfil = imageProfil;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean isDriver() {
        return isDriver;
    }

    public void setDriver(boolean driver) {
        isDriver = driver;
    }

    public LocalDateTime getPickUpTime() {
        return pickUpTime;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setPickUpTime(LocalDateTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}