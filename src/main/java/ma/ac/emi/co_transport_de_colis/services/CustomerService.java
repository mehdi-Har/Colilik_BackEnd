package ma.ac.emi.co_transport_de_colis.services;

import ma.ac.emi.co_transport_de_colis.entities.Customer;
import ma.ac.emi.co_transport_de_colis.entities.User;
import ma.ac.emi.co_transport_de_colis.repositories.AccountRepository;
import ma.ac.emi.co_transport_de_colis.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void createAnnonce(Customer customer, String annonceDetails) {
        System.out.println("Création d'une annonce pour " + customer.getFullName() +
                " : " + annonceDetails);
        // Logique supplémentaire, par ex. enregistrement dans la base de données
    }

    public void cancelOrder(Customer customer, String orderId) {
        System.out.println("Annulation de la commande " + orderId + " pour " + customer.getFullName());
        // Logique supplémentaire, par ex. mise à jour dans la base de données
    }

    public void sendReview(Customer customer, String driverId, String reviewText, int rating) {
        System.out.println("Evaluation soumise par " + customer.getFullName() +
                " pour le conducteur " + driverId + " : " + reviewText + " (Note : " + rating + ")");
        // Logique supplémentaire, par ex. enregistrement de l'évaluation
    }
    public Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElse(null);
    }
}
