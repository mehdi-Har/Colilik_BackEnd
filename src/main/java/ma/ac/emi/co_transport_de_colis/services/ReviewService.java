package ma.ac.emi.co_transport_de_colis.services;

import ma.ac.emi.co_transport_de_colis.entities.Review;
import ma.ac.emi.co_transport_de_colis.repositories.CustomerRepository;
import ma.ac.emi.co_transport_de_colis.repositories.DriverRepository;
import ma.ac.emi.co_transport_de_colis.repositories.OrderRepository;
import ma.ac.emi.co_transport_de_colis.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DriverRepository driverRepository;


    public Review addReview(String orderId, String customerId, String driverId, int rating, String comment) {

        Review review = new Review(orderRepository.findById(orderId).get(), customerRepository.findById(customerId).get(), driverRepository.findById(driverId).get(), rating, comment);
        return reviewRepository.save(review);
    }

    public Review updateReview(String reviewId, int rating, String comment) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        if (optionalReview.isEmpty()) {
            throw new IllegalArgumentException("Review with ID " + reviewId + " not found.");
        }
        Review review = optionalReview.get();
        review.setRating(rating);
        review.setComment(comment);
        return reviewRepository.save(review);
    }

    public void deleteReview(String reviewId) {
        if (!reviewRepository.existsById(reviewId)) {
            throw new IllegalArgumentException("Review with ID " + reviewId + " not found.");
        }
        reviewRepository.deleteById(reviewId);
    }
}
