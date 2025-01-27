package ma.ac.emi.co_transport_de_colis.repositories;

import ma.ac.emi.co_transport_de_colis.entities.Request;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequestRepository extends MongoRepository<Request, String> {
}
