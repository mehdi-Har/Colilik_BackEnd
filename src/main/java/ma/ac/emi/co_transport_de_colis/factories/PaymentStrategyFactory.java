package ma.ac.emi.co_transport_de_colis.factories;

import ma.ac.emi.co_transport_de_colis.entities.PaymentStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentStrategyFactory {

    private final Map<String, PaymentStrategy> strategies;

    public PaymentStrategyFactory(Map<String, PaymentStrategy> strategies) {
        this.strategies = strategies;
    }

    public PaymentStrategy getStrategy(String method) {
        PaymentStrategy strategy = strategies.get(method.toLowerCase());
        if (strategy == null) {
            throw new IllegalArgumentException("payment method is not supported : " + method);
        }
        return strategy;
    }
}
