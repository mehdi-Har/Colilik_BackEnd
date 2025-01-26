package ma.ac.emi.co_transport_de_colis.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.ac.emi.co_transport_de_colis.entities.Announcement;
import ma.ac.emi.co_transport_de_colis.entities.Item;
import ma.ac.emi.co_transport_de_colis.services.AnnouncementService;
import ma.ac.emi.co_transport_de_colis.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private ItemService itemService;
    @PostMapping
    public Announcement createAnnouncement(@RequestBody Announcement announcement) {
        return announcementService.createAnnouncement(announcement);
    }

    @GetMapping
    public List<Announcement> getAllAnnouncements() {
        return announcementService.getAllAnnouncements();
    }

    @GetMapping("/{idAnnouncement}")
    public Optional<Announcement> getAnnouncementById(@PathVariable String idAnnouncement) {
        return announcementService.getAnnouncementById(idAnnouncement);
    }

    @PutMapping("/{idAnnouncement}")
    public Announcement updateAnnouncement(@PathVariable String idAnnouncement, @RequestBody Announcement updatedAnnouncement) {
        return announcementService.updateAnnouncement(idAnnouncement, updatedAnnouncement);
    }

    @DeleteMapping("/{idAnnouncement}")
    public void deleteAnnouncement(@PathVariable String idAnnouncement) {
        announcementService.deleteAnnouncement(idAnnouncement);
    }
    @PostMapping(value = "/users/{userId}/announcements", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAnnouncementWithItemsAndImages(
            @PathVariable String userId,
            @RequestBody Announcement request) {
        try {
            LocalDateTime pickUpTimeParsed = request.getPickUpTime();
            LocalDateTime deliveryTimeParsed = request.getDeliveryTime();

            Announcement announcement = new Announcement();
            announcement.setCustomerId(userId);
            announcement.setPickUpTime(pickUpTimeParsed);
            announcement.setDestination(request.getDepart());
            announcement.setLongDest(request.getLongDest());
            announcement.setLatDest(request.getLatDest());
            announcement.setLongDepart(request.getLongDepart());
            announcement.setLatDepart(request.getLatDepart());
            announcement.setDeliveryTime(deliveryTimeParsed);
            announcement.setSenderName(request.getSenderName());
            announcement.setPhoneNumber(request.getPhoneNumber());
            announcement.setAlternativeSenderPhoneNumber(request.getAlternativeSenderPhoneNumber());
            announcement.setReceiverName(request.getReceiverName());
            announcement.setReceiverPhoneNumber(request.getReceiverPhoneNumber());
            announcement.setAlternativeReceiverPhoneNumber(request.getAlternativeReceiverPhoneNumber());

            Announcement savedAnnouncement = announcementService.createAnnouncement(announcement);
            List<Item> savedItems = new ArrayList<>();

            for (Item itemRequest : request.getItems()) {
                Item item = new Item();
                item.setDimension(itemRequest.getDimension());
                item.setQuantity(itemRequest.getQuantity());
                item.setAnoucmentId(savedAnnouncement.getAnnouncementId());
                Item savedItem = itemService.createItem(item);

                String rootPath = new File("users").getAbsolutePath();
                String userDir = rootPath + "/user_" + userId;
                String announcementDir = userDir + "/announcements/announcement_" + savedAnnouncement.getAnnouncementId();
                String itemFilePath = announcementDir + "/item_" + savedItem.getItemId() + ".jpeg";

                File directory = new File(announcementDir);
                if (!directory.exists() && !directory.mkdirs()) {
                    throw new IOException("Failed to create directories: " + announcementDir);
                }

                byte[] imageBytes = Base64.getDecoder().decode(itemRequest.getPhoto());
                try (FileOutputStream fos = new FileOutputStream(itemFilePath)) {
                    fos.write(imageBytes);
                }

                savedItem.setPhoto(itemFilePath);
                itemService.updateItemPhoto(savedItem.getItemId(), itemFilePath);

                savedItems.add(savedItem);
            }

            announcement.setItems(savedItems);
            announcementService.updateAnnouncementWithItems(savedAnnouncement.getAnnouncementId(), savedItems);

            Map<String, Object> response = new HashMap<>();
            response.put("announcementId", savedAnnouncement.getAnnouncementId());
            response.put("items", savedItems);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, Object> errorDetails = new HashMap<>();
            errorDetails.put("message", "Error creating announcement");
            errorDetails.put("error", e.getMessage());
            errorDetails.put("cause", e.getCause() != null ? e.getCause().toString() : "Unknown cause");

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorDetails);
        }
    }




}

