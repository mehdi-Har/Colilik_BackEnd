package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders") // Stockage dans MongoDB
public class Order {
    @Id
    private String orderId;
    @DBRef
    private Announcement announcement;
    @DBRef
    private Driver driver;
    @DBRef
    private Customer customer;
    private double amount;
    private String currentPosition;
    private String status;

    public Order(Announcement announcement, Driver driver, Customer customer, double amount, String currentPosition, String status) {
        this.setAnnouncement(announcement);
        this.setDriver(driver);
        this.setCustomer(customer);
        this.setAmount(amount);
        this.setCurrentPosition(currentPosition);
        this.setStatus(status);
    }

    public Order() {}

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
