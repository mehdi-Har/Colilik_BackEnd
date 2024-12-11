package ma.ac.emi.co_transport_de_colis.entities;


import org.springframework.stereotype.Component;

@Component("wallet")
public class WalletPayment implements PaymentStrategy {
    @Override
    public void executePayment(double amount) {

    }
}
