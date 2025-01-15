package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "customers")
public class Customer extends User {
    private double walletBalance;
    private int totalOrders;

    @DBRef
    private List<Announcement> announcements= new ArrayList<>();

    public Customer(String password, String fullName, String userEmail, String numero, Double rating, String numeroCIN, String imageCIN, double walletBalance, int totalOrders, String imageProfil) {
        super( password, fullName, userEmail, numero, rating, numeroCIN, imageCIN, imageProfil);
        this.setWalletBalance(walletBalance);
        this.setTotalOrders(totalOrders);
    }

    public Customer(String numero, Double rating, String numeroCIN, String imageCIN, double walletBalance, int totalOrders, String imageProfil) {
        super(numero, rating, numeroCIN, imageCIN, imageProfil);
        this.walletBalance = walletBalance;
        this.totalOrders = totalOrders;
    }
    public Customer() {}

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
    }

    public void addAnnouncement(Announcement announcement) {
        this.announcements.add(announcement);
    }
    public void removeAnnouncement(Announcement announcement) {
        this.announcements.remove(announcement);
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

}
