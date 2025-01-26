package ma.ac.emi.co_transport_de_colis.controllers;

import ma.ac.emi.co_transport_de_colis.entities.Order;
import ma.ac.emi.co_transport_de_colis.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
//    @PostMapping
//    public Order createOrder(
//            @RequestParam String announcementId,
//            @RequestParam String driverId,
//            @RequestParam double amount) {
//        return orderService.createOrder(announcementId, driverId);
//    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{idOrder}")
    public Optional<Order> getOrderById(@PathVariable String idOrder) {
        return orderService.getOrderById(idOrder);
    }

//    @PutMapping("/{idOrder}")
//    public Order updateOrder(@PathVariable String idOrder, @RequestBody Order updatedOrder) {
//        return orderService.updateOrder(idOrder, updatedOrder);
//    }
    @GetMapping("/ordersById/{clerkId}")
    public List<Order> getOrdersByClerkId(@PathVariable String clerkId) {
        return orderService.getOrdersByClerkId(clerkId);
    }
    @DeleteMapping("/{idOrder}")
    public void deleteOrder(@PathVariable String idOrder) {
        orderService.deleteOrder(idOrder);
    }
}
