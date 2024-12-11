package ma.ac.emi.co_transport_de_colis.controllers;

import ma.ac.emi.co_transport_de_colis.entities.Customer;
import ma.ac.emi.co_transport_de_colis.entities.Driver;
import ma.ac.emi.co_transport_de_colis.entities.Review;
import ma.ac.emi.co_transport_de_colis.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public Review addReview(@RequestParam String orderId,
                            @RequestParam String customerId,
                            @RequestParam String driverId,
                            @RequestParam int rating,
                            @RequestParam String comment) {
        return reviewService.addReview(orderId, customerId, driverId, rating, comment);
    }

    @PutMapping("/{reviewId}")
    public Review updateReview(@PathVariable String reviewId,
                               @RequestParam int rating,
                               @RequestParam String comment) {
        return reviewService.updateReview(reviewId, rating, comment);
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable String reviewId) {
        reviewService.deleteReview(reviewId);
    }

}
