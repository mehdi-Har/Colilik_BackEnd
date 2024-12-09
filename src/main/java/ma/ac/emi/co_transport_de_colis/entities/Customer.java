package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer extends User {

    private double walletBalance;
    private int totalOrders;

    public Customer(String userId, String password, String fullName, String userEmail, String numero, Double rating, String numeroCIN, String imageCIN) {
        super(userId, password, fullName, userEmail, numero, rating, numeroCIN, imageCIN);
    }

    public Customer(String numero, Double rating, String numeroCIN, String imageCIN) {
        super(numero, rating, numeroCIN, imageCIN);
    }

    public Customer(String userId, String password, String fullName, String userEmail, String numero, Double rating, String numeroCIN, String imageCIN, int totalOrders, double walletBalance) {
        super(userId, password, fullName, userEmail, numero, rating, numeroCIN, imageCIN);
        this.totalOrders = totalOrders;
        this.walletBalance = walletBalance;
    }

    public Customer(String numero, Double rating, String numeroCIN, String imageCIN, int totalOrders, double walletBalance) {
        super(numero, rating, numeroCIN, imageCIN);
        this.totalOrders = totalOrders;
        this.walletBalance = walletBalance;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "walletBalance=" + walletBalance +
                ", totalOrders=" + totalOrders +
                '}';
    }
}
