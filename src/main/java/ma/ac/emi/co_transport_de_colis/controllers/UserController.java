package ma.ac.emi.co_transport_de_colis.controllers;

import ma.ac.emi.co_transport_de_colis.entities.User;
import ma.ac.emi.co_transport_de_colis.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Value("${image.upload.path}")  // Define the base upload path in your application.properties
    private String uploadDir;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:8081")  // Remplace par l'URL de ton frontend (par ex. Expo)
    @GetMapping("/{userid}")
    public User getUser(@PathVariable("userid") String userid) {
        return userService.getUser(userid);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @RequestParam String fullName,
            @RequestParam String email,
            @RequestParam String clerkId,
            @RequestParam String phone,
            @RequestParam String numeroCIN,
            @RequestParam(required = false) MultipartFile imageCIN,
            @RequestParam(required = false) MultipartFile imageProfile) throws IOException {

        String userDirectoryPath = uploadDir + File.separator + clerkId;
        File userDirectory = new File(userDirectoryPath);
        if (!userDirectory.exists()) {
            userDirectory.mkdirs();
        }


        saveFile(imageCIN, userDirectoryPath + File.separator + "cin.png");
        saveFile(imageProfile, userDirectoryPath + File.separator + "profile.png");

        User user = userService.register(fullName, email, clerkId, phone, userDirectoryPath,numeroCIN);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }

    private void saveFile(MultipartFile file, String filePath) throws IOException {
        File destination = new File(filePath);
        FileCopyUtils.copy(file.getBytes(), destination);
    }



    @GetMapping(path = "/imageProfile/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImageProfile(@PathVariable String id) throws IOException {
        User user = userService.getUser(id);
        String image = user.getImageProfil();
        System.out.println(image);
        File file = new File(image);
        Path profileImagePath = Paths.get(file.toURI());
        return Files.readAllBytes(profileImagePath);

    }


    @GetMapping(path = "/imageCIN/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImageCIN(@PathVariable String id) throws IOException {
        User user = userService.getUser(id);
        String image = user.getImageCIN();
        System.out.println(image);
        File file = new File(image);
        Path profileImagePath = Paths.get(file.toURI());
        return Files.readAllBytes(profileImagePath);

    }



//    @GetMapping(path = "/imageProfil/{id}", produces = MediaType.IMAGE_PNG_VALUE)
//    public byte[] getImage(@PathVariable String id) throws IOException {
//        User user = userService.findUserById(id);
//        String image=user.getImageProfil();
//        File file= new File(System.getProperty("user.home")+"/images/"+image);
//        Path path= Paths.get(file.toURI());
//        return Files.readAllBytes(path);
//    }

    @GetMapping("/getId/{clerkId}")
    public String getUserIdByClerkId(@PathVariable("clerkId") String clerkId) {
        return userService.getUserIdByClerkId(clerkId);
    }
}
