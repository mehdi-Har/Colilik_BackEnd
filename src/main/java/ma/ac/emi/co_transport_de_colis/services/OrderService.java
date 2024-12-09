package ma.ac.emi.co_transport_de_colis.services;

import ma.ac.emi.co_transport_de_colis.entities.Order;
import ma.ac.emi.co_transport_de_colis.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(String idOrder) {
        return orderRepository.findById(idOrder);
    }

    public Order updateOrder(String idOrder, Order updatedOrder) {
        return orderRepository.findById(idOrder)
                .map(order -> {
                    order.setIdAnnouncement(updatedOrder.getIdAnnouncement());
                    order.setDriverId(updatedOrder.getDriverId());
                    order.setCustomerId(updatedOrder.getCustomerId());
                    order.setAmount(updatedOrder.getAmount());
                    order.setCurrentPosition(updatedOrder.getCurrentPosition());
                    order.setStatus(updatedOrder.getStatus());
                    return orderRepository.save(order);
                })
                .orElseThrow(() -> new RuntimeException("Order not found : " + idOrder));
    }

    public void deleteOrder(String idOrder) {
        orderRepository.deleteById(idOrder);
    }
}
