package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "payments")
public class Payment {
    @Id
    private String paymentId;
    @DBRef
    private Order order;
    @DBRef
    private User customer;
    @DBRef
    private User driver;

    private double amount;
    private PaymentStrategy paymentStrategy;
    private LocalDateTime timestamp;

    public Payment(Order order, User customer, User driver, double amount, PaymentStrategy paymentStrategy, LocalDateTime timestamp) {
        this.setOrder(order);
        this.setCustomer(customer);
        this.setDriver(driver);
        this.setAmount(amount);
        this.setPaymentStrategy(paymentStrategy);
        this.setTimestamp(timestamp);
    }

    public Payment() {}


    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void effectuerPaiement() {
        paymentStrategy.executePayment(this.amount);
    }
}
