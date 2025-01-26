package ma.ac.emi.co_transport_de_colis.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ma.ac.emi.co_transport_de_colis.Enums.EnumStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Document(collection = "orders")
public class Order {
    @Id
    private String orderId;
    @DBRef
    private Announcement announcement;
    private String driverId;
    private String customerId;
    @JsonFormat(pattern = "HH:mm:ss")
    private EnumStatus status;
    private double currentLatitude;
    private double currentLongitude;


    public Order(Announcement announcement, String driverId, String customerId, EnumStatus status, double currentLatitude, double currentLongitude) {
        this.announcement = announcement;
        this.driverId = driverId;
        this.customerId = customerId;
        this.status = status;
        this.currentLatitude = currentLatitude;
        this.currentLongitude = currentLongitude;

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

    public String getDriverId() {
        return driverId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getCurrentLatitude() {
        return currentLatitude;
    }

    public void setCurrentLatitude(double currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    public double getCurrentLongitude() {
        return currentLongitude;
    }

    public void setCurrentLongitude(double currentLongitude) {
        this.currentLongitude = currentLongitude;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }



}
