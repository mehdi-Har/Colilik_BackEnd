package ma.ac.emi.co_transport_de_colis.services;


import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.EphemeralKey;
import com.stripe.model.PaymentIntent;
import com.stripe.param.EphemeralKeyCreateParams;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${stripe.secret.key}")
    private String secretKey;

    @Value("${stripe.api.version}")
    private String apiVersion;

    public StripeService() {
        // Set API key during service initialization
        Stripe.apiKey = "sk_test_51QXqdbF2KssLMFcIBQohxrvWqwJAtPN1DDMjVhAkh9EUqJDZA9wq9jnMI7mHMVd76ULfjWXqdJUNwucmiBkDTR9600kMK0UGqP";
    }

    public Map<String, String> createPaymentSheetData() throws StripeException {
        // Create a customer
        Map<String, Object> customerParams = new HashMap<>();
        com.stripe.model.Customer customer = com.stripe.model.Customer.create(customerParams);

        // Create an ephemeral key for the customer
        EphemeralKeyCreateParams ephemeralKeyParams = EphemeralKeyCreateParams.builder()
                .setCustomer(customer.getId())
                .setStripeVersion(apiVersion)
                .build();
        EphemeralKey ephemeralKey = EphemeralKey.create(ephemeralKeyParams);

        // Create a Payment Intent
        PaymentIntentCreateParams paymentIntentParams = PaymentIntentCreateParams.builder()
                .setAmount(1000L) // Amount in cents (e.g., $10.00)
                .setCurrency("usd")
                .setCustomer(customer.getId())
                .build();
        PaymentIntent paymentIntent = PaymentIntent.create(paymentIntentParams);

        // Return client secret, ephemeral key, and customer ID
        Map<String, String> responseData = new HashMap<>();
        responseData.put("paymentIntent", paymentIntent.getClientSecret());
        responseData.put("ephemeralKey", ephemeralKey.getSecret());
        responseData.put("customer", customer.getId());
        return responseData;
    }
}