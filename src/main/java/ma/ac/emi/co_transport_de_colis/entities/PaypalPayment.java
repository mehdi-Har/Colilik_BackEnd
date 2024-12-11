package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.stereotype.Component;

@Component("paypal")
public class PaypalPayment implements PaymentStrategy {
    @Override
    public void executePayment(double amount) {

    }
}
