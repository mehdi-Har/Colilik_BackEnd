package ma.ac.emi.co_transport_de_colis.entities;

public class StripePayment implements PaymentStrategy {

    private Long amount;
    private String currency;
    @Override
    public void executePayment(double amount) {

    }

    public StripePayment(Long amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public StripePayment() {
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
