package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders") // Stockage dans MongoDB
public class Order {
    @Id
    private String idOrder;
    private String idAnnouncement;
    private String driverId;
    private String customerId;
    private double amount;
    private String currentPosition;
    private String status;

    public Order(String idOrder, String idAnnouncement, String driverId, String customerId, double amount, String currentPosition, String status) {
        this.idOrder = idOrder;
        this.idAnnouncement = idAnnouncement;
        this.driverId = driverId;
        this.customerId = customerId;
        this.amount = amount;
        this.currentPosition = currentPosition;
        this.status = status;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdAnnouncement() {
        return idAnnouncement;
    }

    public void setIdAnnouncement(String idAnnouncement) {
        this.idAnnouncement = idAnnouncement;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    @Override
    public String toString() {
        return "Order{" +
                "idOrder='" + idOrder + '\'' +
                ", idAnnouncement='" + idAnnouncement + '\'' +
                ", driverId='" + driverId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", amount=" + amount +
                ", currentPosition='" + currentPosition + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
