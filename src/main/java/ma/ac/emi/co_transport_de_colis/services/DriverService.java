package ma.ac.emi.co_transport_de_colis.services;

import ma.ac.emi.co_transport_de_colis.entities.Customer;
import ma.ac.emi.co_transport_de_colis.entities.Driver;
import ma.ac.emi.co_transport_de_colis.repositories.DriverRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    DriverRepository driverRepository;

    // Méthode pour valider une annonce
    public void validateAnnonce(Driver driver, String annonceId) {
        System.out.println("Le conducteur " + driver.getFullName() + " a validé l'annonce " + annonceId);
        // Logique métier pour valider l'annonce
    }

    // Méthode pour refuser une annonce
    public void refuserAnnonce(Driver driver, String annonceId) {
        System.out.println("Le conducteur " + driver.getFullName() + " a refusé l'annonce " + annonceId);
        // Logique métier pour refuser l'annonce
    }

    // Méthode pour soumettre une évaluation pour un client
    public void sendReview(Driver driver, String customerId, String reviewText, int rating) {
        System.out.println("Le conducteur " + driver.getFullName() +
                " a évalué le client " + customerId + " avec la note de " + rating +
                ". Commentaire : " + reviewText);
        // Logique pour enregistrer l'évaluation
    }

    public Driver findDriverById(String id) {
        return driverRepository.findById(id).orElse(null);
    }
}
