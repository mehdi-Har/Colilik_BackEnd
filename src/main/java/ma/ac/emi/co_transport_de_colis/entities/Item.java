package ma.ac.emi.co_transport_de_colis.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class Item {
    @Id
    private String itemId;
    private String photo;
    private int quantity;
    private int  dimension;

    private String anoucmentId;

    public Item(String photo, int quantity, int dimension, String anoucmentId) {
        this.photo = photo;
        this.quantity = quantity;
        this.dimension = dimension;
        this.anoucmentId = anoucmentId;
    }

    public Item() {}

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public String getAnoucmentId() {
        return anoucmentId;
    }

    public void setAnoucmentId(String anoucmentId) {
        this.anoucmentId = anoucmentId;
    }
}

