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

    public Customer(String clerkId, String fullName, String userEmail, String numeroCIN, String imageProfil, String imageCIN, double walletBalance, int totalOrders, List<Announcement> announcements) {
        super(clerkId, fullName, userEmail, numeroCIN, imageProfil, imageCIN);
        this.walletBalance = walletBalance;
        this.totalOrders = totalOrders;
        this.announcements = announcements;
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
