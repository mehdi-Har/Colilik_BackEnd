package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class Item {
    @Id
    private String idItem;
    private String photo;
    private String description;
    private int quantity;
    private Dimension dimension;
    private double weight;

    public Item(String idItem, String photo, String description, int quantity, Dimension dimension, double weight) {
        this.idItem = idItem;
        this.photo = photo;
        this.description = description;
        this.quantity = quantity;
        this.dimension = dimension;
        this.weight = weight;
    }
    public Item() {}

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem='" + idItem + '\'' +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", dimension=" + dimension +
                ", weight=" + weight +
                '}';
    }
}

