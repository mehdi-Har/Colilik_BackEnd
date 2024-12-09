package ma.ac.emi.co_transport_de_colis.controllers;

import ma.ac.emi.co_transport_de_colis.entities.Driver;
import ma.ac.emi.co_transport_de_colis.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/{driverId}/annonces/{annonceId}/validate")
    public void validateAnnonce(@PathVariable String driverId, @PathVariable String annonceId) {
        Driver driver = getDriverById(driverId);
        driverService.validateAnnonce(driver, annonceId);
    }

    @PostMapping("/{driverId}/annonces/{annonceId}/refuse")
    public void refuserAnnonce(@PathVariable String driverId, @PathVariable String annonceId) {
        Driver driver = getDriverById(driverId);
        driverService.refuserAnnonce(driver, annonceId);
    }

    @PostMapping("/{driverId}/reviews")
    public void sendReview(@PathVariable String driverId,
                           @RequestParam String customerId,
                           @RequestParam String reviewText,
                           @RequestParam int rating) {
        Driver driver = getDriverById(driverId);
        driverService.sendReview(driver, customerId, reviewText, rating);
    }

    private Driver getDriverById(String driverId) {
        return driverService.findDriverById(driverId);
    }
}
