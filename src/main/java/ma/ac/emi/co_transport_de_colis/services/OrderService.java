package ma.ac.emi.co_transport_de_colis.services;

import ma.ac.emi.co_transport_de_colis.entities.Order;
import ma.ac.emi.co_transport_de_colis.repositories.AnnouncementRepository;
import ma.ac.emi.co_transport_de_colis.repositories.OrderRepository;
import ma.ac.emi.co_transport_de_colis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private UserRepository driverRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(String idOrder) {
        return orderRepository.findById(idOrder);
    }

    public List<Order> getOrdersByClerkId(String clerkId) {
        return orderRepository.findByCustomerId(clerkId);
    }
    public void deleteOrder(String idOrder) {
        orderRepository.deleteById(idOrder);
    }
}
