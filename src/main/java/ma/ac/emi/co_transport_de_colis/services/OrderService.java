package ma.ac.emi.co_transport_de_colis.services;

import ma.ac.emi.co_transport_de_colis.entities.DriverProposal;
import ma.ac.emi.co_transport_de_colis.entities.Order;
import ma.ac.emi.co_transport_de_colis.repositories.AnnouncementRepository;
import ma.ac.emi.co_transport_de_colis.repositories.DriverRepository;
import ma.ac.emi.co_transport_de_colis.repositories.OrderRepository;
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
    private DriverRepository driverRepository;

    public Order createOrder(String announcementId, String driverId, double amount) {
        List<DriverProposal> proposals = announcementService.getProposals(announcementId);

        // Vérifier que le driverId existe dans les propositions
        boolean proposalExists = proposals.stream()
                .anyMatch(proposal -> proposal.getDriverId().equals(driverId));

        if (!proposalExists) {
            throw new RuntimeException("proposal not valid for this driver");
        }

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
