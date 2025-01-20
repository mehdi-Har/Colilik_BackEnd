package ma.ac.emi.co_transport_de_colis.controllers;

import com.stripe.exception.StripeException;
import ma.ac.emi.co_transport_de_colis.services.StripeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class StripeController {

    private final StripeService stripeService;

    public StripeController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/sheet")
    public ResponseEntity<Map<String, String>> createPaymentSheet() {
        try {
            Map<String, String> paymentSheetData = stripeService.createPaymentSheetData();
            return ResponseEntity.ok(paymentSheetData);
        } catch (StripeException e) {
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }

//    @PostMapping("/charge")
//    public ResponseEntity<Map<String, Object>> createCharge(@RequestBody ChargeRequest chargeRequest) {
//        try {
//            // Retrieve customer and create a PaymentIntent
//            String customerId = "cus_RaqhBoXIqqPNGr"; // Use the real customer ID
//            Stripe.apiKey = "sk_test_YOUR_SECRET_KEY"; // Use your Stripe secret key
//
//            // Create the PaymentIntent
//            Map<String, Object> params = new HashMap<>();
//            params.put("amount", chargeRequest.getAmount());
//            params.put("currency", "usd");
//            params.put("customer", customerId);
//
//            PaymentIntent paymentIntent = PaymentIntent.create(params);
//
//            // Create an ephemeral key for the client
//            EphemeralKeyCreateParams ephemeralKeyParams =
//                    EphemeralKeyCreateParams.builder().setCustomer(customerId).build();
//
//            EphemeralKey ephemeralKey = EphemeralKey.create(ephemeralKeyParams,
//                    Stripe.apiKey);
//
//            // Send back the ephemeralKey and paymentIntent
//            Map<String, Object> response = new HashMap<>();
//            response.put("ephemeralKey", ephemeralKey.getId());
//            response.put("paymentIntent", paymentIntent.getClientSecret());
//
//            return ResponseEntity.ok(response);
//        } catch (StripeException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", e.getMessage()));
//        }
//    }

}