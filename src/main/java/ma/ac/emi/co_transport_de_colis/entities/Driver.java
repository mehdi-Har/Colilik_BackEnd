package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "drivers")
public class Driver extends User {
    private double earnings;
    private int totalDeliveries;

    public Driver(String password, String fullName, String userEmail, String numero, Double rating, String numeroCIN, String imageCIN, String imageProfil) {
        super(password, fullName, userEmail, numero, rating, numeroCIN, imageCIN, imageProfil);
    }

    public Driver(String numero, Double rating, String numeroCIN, String imageCIN, String imageProfil) {
        super(numero, rating, numeroCIN, imageCIN, imageProfil);
    }

    public Driver(String password, String fullName, String userEmail, String numero, Double rating, String numeroCIN, String imageCIN, double earnings, int totalDeliveries, String imageProfil) {
        super(password, fullName, userEmail, numero, rating, numeroCIN, imageCIN, imageProfil);
        this.setEarnings(earnings);
        this.setTotalDeliveries(totalDeliveries);
    }

    public Driver(String numero, Double rating, String numeroCIN, String imageCIN, double earnings, int totalDeliveries , String imageProfil) {
        super(numero, rating, numeroCIN, imageCIN, imageProfil);
        this.setEarnings(earnings);
        this.setTotalDeliveries(totalDeliveries);
    }

    public Driver() {}

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public int getTotalDeliveries() {
        return totalDeliveries;
    }

    public void setTotalDeliveries(int totalDeliveries) {
        this.totalDeliveries = totalDeliveries;
    }

}
