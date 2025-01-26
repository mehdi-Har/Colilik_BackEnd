package ma.ac.emi.co_transport_de_colis;

import ma.ac.emi.co_transport_de_colis.Enums.EnumStatus;
import ma.ac.emi.co_transport_de_colis.entities.Announcement;
import ma.ac.emi.co_transport_de_colis.entities.Order;
import ma.ac.emi.co_transport_de_colis.entities.User;
import ma.ac.emi.co_transport_de_colis.repositories.AnnouncementRepository;
import ma.ac.emi.co_transport_de_colis.repositories.OrderRepository;
import ma.ac.emi.co_transport_de_colis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TestOrderService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AnnouncementRepository announcementRepository;
    public void testOrderCreation() {
        // Clear existing collections (optional)
        userRepository.deleteAll();
        orderRepository.deleteAll();


        User testUser = new User(
                "1",
                "John Doe",
                "john.doe@example.com",
                "AB123456",
                "profile.jpg",
                "cin.jpg"
        );
        userRepository.save(testUser);
        Announcement announcement = announcementRepository.findById("679638cece3ef9774fb41375")
                .orElseThrow(() -> new IllegalArgumentException("Announcement not found"));

        // Create an order using the announcement
        Order testOrder = new Order(
                announcement,                // Associated announcement
                "driver123",                 // Driver ID (placeholder value)
                testUser.getClerkId(),            // Customer ID
                EnumStatus.PENDING,          // Status
                37.7749,                     // Current latitude (placeholder)
                -122.4194                    // Current longitude (placeholder)
        );
        Order testOrder2 = new Order(
                announcement,                // Associated announcement
                "driver123",                 // Driver ID (placeholder value)
                testUser.getClerkId(),            // Customer ID
                EnumStatus.DELIVERED,          // Status
                37.7749,                     // Current latitude (placeholder)
                -122.4194                    // Current longitude (placeholder)
        );

        orderRepository.save(testOrder);
        orderRepository.save(testOrder2);
    }
}
