package ma.ac.emi.co_transport_de_colis.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "reviews")
public class Review {

    @Id
    private String id;
    @DBRef
    private Order order;
    @DBRef
    private User customer;
    @DBRef
    private User driver;
    @Min(1)  @Max(5)
    private int rating;
    private String comment;
    private LocalDateTime timestamp;

    public Review(Order order, User customer, User driver, int rating, String comment) {
        setOrder(order);
        setCustomer(customer);
        setDriver(driver);
        setRating(rating);
        setComment(comment);
        setTimestamp(LocalDateTime.now());
    }

    public Review() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

