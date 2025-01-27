package ma.ac.emi.co_transport_de_colis.repositories;

import ma.ac.emi.co_transport_de_colis.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUserEmail(String userEmail);
    @Query("{ 'isDriver': true }")
    List<User> findByIsDriverTrue();
    String findUserIdByClerkId(String clerkId);
}
