package ma.ac.emi.co_transport_de_colis.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User extends Account {
    private Double rating;
    private String numeroCIN;
    private String imageProfil;
    private String imageCIN;


    public User(String clerkId, String fullName, String userEmail,String numeroCIN, String imageProfil, String imageCIN) {
        super(clerkId, fullName, userEmail);
        this.rating = 0.0;
        this.numeroCIN = numeroCIN;
        this.imageProfil = imageProfil;
        this.imageCIN = imageCIN;

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
}