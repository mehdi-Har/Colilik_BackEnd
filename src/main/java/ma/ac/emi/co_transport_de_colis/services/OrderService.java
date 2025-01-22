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

    public Order createOrder(String announcementId, String driverId, double amount) {


        Order order = new Order();
        order.setAnnouncement(announcementRepository.findById(announcementId).get());
        order.setDriver(driverRepository.findById(driverId).get());
        order.setAmount(amount);

        announcementService.markAnnouncementAsCompleted(announcementId);

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
                    order.setAnnouncement(updatedOrder.getAnnouncement());
                    order.setDriver(updatedOrder.getDriver());
                    order.setCustomer(updatedOrder.getCustomer());
                    order.setAmount(updatedOrder.getAmount());
                    order.setCurrentLatitude(updatedOrder.getCurrentLatitude());
                    order.setCurrentLongitude(updatedOrder.getCurrentLongitude());
                    order.setStatus(updatedOrder.getStatus());
                    return orderRepository.save(order);
                })
                .orElseThrow(() -> new RuntimeException("Order not found : " + idOrder));
    }

    public void deleteOrder(String idOrder) {
        orderRepository.deleteById(idOrder);
    }
}
