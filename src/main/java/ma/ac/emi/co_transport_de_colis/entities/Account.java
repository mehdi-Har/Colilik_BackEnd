package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "accounts")
public class Account {
    @Id
    private String userId;
    private String clerkId;
    private String fullName;
    private String userEmail;

    public Account() {}

    public Account(String clerkId, String fullName, String userEmail) {
        this.setClerkId(clerkId);
        this.setFullName(fullName);
        this.setUserEmail(userEmail);
    }

    public String getUserId() {
        return userId;
    }

    public String getClerkId() {
        return clerkId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setClerkId(String clerkId) {
        this.clerkId = clerkId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
