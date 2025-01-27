package ma.ac.emi.co_transport_de_colis.services;

import ma.ac.emi.co_transport_de_colis.entities.User;
import ma.ac.emi.co_transport_de_colis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(String fullName, String email, String clerkId, String phone, String userDirectoryPath, String numeroCIN) {
        User user = new User();
        user.setFullName(fullName);
        user.setUserEmail(email);
        user.setPhone(phone);
        user.setRating(0.0);
        user.setClerkId(clerkId);
        user.setUserId(clerkId);
        user.setNumeroCIN(numeroCIN);
        user.setImageCIN(userDirectoryPath + File.separator + "cin.png");
        user.setImageProfil(userDirectoryPath + File.separator + "profile.png");

        return userRepository.save(user);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id).get();
    }

    public String getUserIdByClerkId(String clerkId) {
        return userRepository.findUserIdByClerkId(clerkId);

    }
    public List<User> getAllDrivers() {
        return userRepository.findByIsDriverTrue();
    }
}
