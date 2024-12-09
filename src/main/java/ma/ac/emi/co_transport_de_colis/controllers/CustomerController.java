package ma.ac.emi.co_transport_de_colis.controllers;

import ma.ac.emi.co_transport_de_colis.entities.Customer;
import ma.ac.emi.co_transport_de_colis.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/{customerId}/annonces")
    public void createAnnonce(@PathVariable String customerId, @RequestParam String details) {
        Customer customer= customerService.findCustomerById(customerId);
        customerService.createAnnonce(customer, details);
    }

    @PostMapping("/{customerId}/orders/{orderId}/cancel")
    public void cancelOrder(@PathVariable String customerId, @PathVariable String orderId) {
        Customer customer = customerService.findCustomerById(customerId);
        customerService.cancelOrder(customer, orderId);
    }

    @PostMapping("/{customerId}/reviews")
    public void sendReview(@PathVariable String customerId,
                           @RequestParam String driverId,
                           @RequestParam String reviewText,
                           @RequestParam int rating) {
        Customer customer =customerService.findCustomerById(customerId);
        customerService.sendReview(customer, driverId, reviewText, rating);
    }


}
