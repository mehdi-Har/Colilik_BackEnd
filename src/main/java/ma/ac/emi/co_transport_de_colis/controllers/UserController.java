package ma.ac.emi.co_transport_de_colis.controllers;

import ma.ac.emi.co_transport_de_colis.entities.User;
import ma.ac.emi.co_transport_de_colis.services.UserService;
import org.springframework.http.HttpStatus;
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
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping("/drivers/nearby")
    public ResponseEntity<List<User>> getNearbyDrivers(
            @RequestParam double pickupLongitude,
            @RequestParam double pickupLatitude,
            @RequestParam double destinationLongitude,
            @RequestParam double destinationLatitude,
            @RequestParam String pickupTime,
            @RequestParam String deliveryTime,
            @RequestParam double toleranceDistance,  // Tolerance in km
            @RequestParam long toleranceTimeInMinutes // Tolerance in minutes
    ) {
        try {
            LocalDateTime pickUpTimeParsed = LocalDateTime.parse(pickupTime);
            LocalDateTime deliveryTimeParsed = LocalDateTime.parse(deliveryTime);

            List<User> allDrivers = userService.getAllDrivers(); // Add a service to filter drivers
            List<User> nearbyDrivers = allDrivers.stream()
                    .filter(driver -> {
                        double distanceToPickup = calculateDistance(
                                pickupLatitude, pickupLongitude,
                                driver.getLatDepart(), driver.getLongDepart());
                        double distanceToDestination = calculateDistance(
                                destinationLatitude, destinationLongitude,
                                driver.getLatDest(), driver.getLongDest());
                        long pickupTimeDifference = Math.abs(Duration.between(driver.getPickUpTime(), pickUpTimeParsed).toMinutes());
                        long deliveryTimeDifference = Math.abs(Duration.between(driver.getDeliveryTime(), deliveryTimeParsed).toMinutes());

                        return distanceToPickup <= toleranceDistance &&
                                distanceToDestination <= toleranceDistance &&
                                pickupTimeDifference <= toleranceTimeInMinutes &&
                                deliveryTimeDifference <= toleranceTimeInMinutes;
                    })
                    .sorted(Comparator.comparingDouble(User::getRating).reversed()) // Sort by rating
                    .limit(10)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(nearbyDrivers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Haversine formula implementation for geospatial distance in kilometers
        final int R = 6371; // Earth's radius in km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Distance in km
    }
}
