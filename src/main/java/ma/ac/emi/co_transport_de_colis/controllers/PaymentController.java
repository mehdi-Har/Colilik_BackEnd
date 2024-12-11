package ma.ac.emi.co_transport_de_colis.controllers;

import ma.ac.emi.co_transport_de_colis.entities.Payment;
import ma.ac.emi.co_transport_de_colis.entities.PaymentStrategy;
import ma.ac.emi.co_transport_de_colis.factories.PaymentStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentStrategyFactory paymentStrategyFactory;

    @PostMapping("/process")
    public void processPayment(@RequestBody Payment payment, @RequestParam String method) {
        PaymentStrategy paymentStrategy = paymentStrategyFactory.getStrategy(method);
        paymentStrategy.executePayment(payment.getAmount());
    }
}
