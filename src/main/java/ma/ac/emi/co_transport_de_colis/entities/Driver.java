package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "drivers")
public class Driver extends User {
    private int totalDeliveries;

    public Driver(String clerkId, String fullName, String userEmail, Double rating, String numeroCIN, String imageProfil, String imageCIN, double wallet, boolean isDriver, int totalDeliveries) {
        super(clerkId, fullName, userEmail, rating, numeroCIN, imageProfil, imageCIN, wallet, isDriver);
        this.totalDeliveries = totalDeliveries;
    }

    public Driver() {}


    public int getTotalDeliveries() {
        return totalDeliveries;
    }

    public void setTotalDeliveries(int totalDeliveries) {
        this.totalDeliveries = totalDeliveries;
    }

}
