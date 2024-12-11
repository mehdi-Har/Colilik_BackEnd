package ma.ac.emi.co_transport_de_colis.services;

import ma.ac.emi.co_transport_de_colis.entities.Payment;
import ma.ac.emi.co_transport_de_colis.entities.PaymentStrategy;
import ma.ac.emi.co_transport_de_colis.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public void processPayment(Payment payment, PaymentStrategy paymentStrategy) {
        payment.setTimestamp(LocalDateTime.now());
        payment.setPaymentStrategy(paymentStrategy);
        payment.effectuerPaiement();
        paymentRepository.save(payment);

    }
}
