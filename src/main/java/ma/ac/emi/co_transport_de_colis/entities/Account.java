package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "accounts")
public class Account {
    @Id
    private String userId;
    private String password;
    private String fullName;
    private String userEmail;

    public Account() {}
    public Account(String userId, String password, String fullName, String userEmail) {
        this.userId = userId;
        this.password = password;
        this.fullName = fullName;
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
