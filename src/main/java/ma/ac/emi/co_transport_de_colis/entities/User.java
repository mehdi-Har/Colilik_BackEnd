package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User extends Account {
    private String numero;
    private Double rating;
    private String numeroCIN;
    private String imageCIN;

    public User(String password, String fullName, String userEmail, String numero, Double rating, String numeroCIN, String imageCIN) {
        super(password, fullName, userEmail);
        this.numero = numero;
        this.rating = rating;
        this.numeroCIN = numeroCIN;
        this.imageCIN = imageCIN;
    }

    public User(String numero, Double rating, String numeroCIN, String imageCIN) {
        this.numero = numero;
        this.rating = rating;
        this.numeroCIN = numeroCIN;
        this.imageCIN = imageCIN;
    }
public User() {}
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

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
}