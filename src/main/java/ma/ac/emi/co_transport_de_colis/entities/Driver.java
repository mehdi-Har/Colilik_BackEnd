package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "drivers")
public class Driver extends User {
    private double earnings;
    private int totalDeliveries;

    public Driver(String password, String fullName, String userEmail, String numero, Double rating, String numeroCIN, String imageCIN) {
        super(password, fullName, userEmail, numero, rating, numeroCIN, imageCIN);
    }

    public Driver(String numero, Double rating, String numeroCIN, String imageCIN) {
        super(numero, rating, numeroCIN, imageCIN);
    }

    public Driver(String password, String fullName, String userEmail, String numero, Double rating, String numeroCIN, String imageCIN, double earnings, int totalDeliveries) {
        super(password, fullName, userEmail, numero, rating, numeroCIN, imageCIN);
        this.setEarnings(earnings);
        this.setTotalDeliveries(totalDeliveries);
    }

    public Driver(String numero, Double rating, String numeroCIN, String imageCIN, double earnings, int totalDeliveries) {
        super(numero, rating, numeroCIN, imageCIN);
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
