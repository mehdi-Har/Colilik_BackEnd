package ma.ac.emi.co_transport_de_colis.controllers;

import ma.ac.emi.co_transport_de_colis.entities.User;
import ma.ac.emi.co_transport_de_colis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.findUserById(id);
    }

    @GetMapping(path = "/imageProfil/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@PathVariable String id) throws IOException {
        User user = userService.findUserById(id);
        String image=user.getImageProfil();
        File file= new File(System.getProperty("user.home")+"/images/"+image);
        Path path= Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }
}
