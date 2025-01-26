package ma.ac.emi.co_transport_de_colis.services;

import ma.ac.emi.co_transport_de_colis.entities.Announcement;
import ma.ac.emi.co_transport_de_colis.entities.Item;
import ma.ac.emi.co_transport_de_colis.repositories.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    public Announcement createAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    public Optional<Announcement> getAnnouncementById(String idAnnouncement) {
        return announcementRepository.findById(idAnnouncement);
    }

    public Announcement updateAnnouncement(String idAnnouncement, Announcement updatedAnnouncement) {
        return announcementRepository.findById(idAnnouncement)
                .map(announcement -> {
                    announcement.setPickUpTime(updatedAnnouncement.getPickUpTime());
                    announcement.setLatDepart(updatedAnnouncement.getLatDepart());
                    announcement.setLongDepart(updatedAnnouncement.getLongDepart());
                    announcement.setLatDest(updatedAnnouncement.getLatDest());
                    announcement.setLongDest(updatedAnnouncement.getLongDest());
                    announcement.setDeliveryTime(updatedAnnouncement.getDeliveryTime());
                    return announcementRepository.save(announcement);
                })
                .orElseThrow(() -> new RuntimeException("Announcement not found : " + idAnnouncement));
    }

    public void deleteAnnouncement(String idAnnouncement) {
        announcementRepository.deleteById(idAnnouncement);
    }


    public Announcement addItemToAnnouncement(String idAnnouncement, Item item) {
        return announcementRepository.findById(idAnnouncement)
                .map(announcement -> {
                    announcement.addItem(item);
                    return announcementRepository.save(announcement);
                })
                .orElseThrow(() -> new RuntimeException("Annoncement not found : " + idAnnouncement));
    }

    public Announcement removeItemFromAnnouncement(String idAnnouncement, Item item) {
        return announcementRepository.findById(idAnnouncement)
                .map(announcement -> {
                    announcement.removeItem(item);
                    return announcementRepository.save(announcement);
                })
                .orElseThrow(() -> new RuntimeException("Annoncement not found : " + idAnnouncement));
    }

    public void updateAnnouncementWithItems(String announcementId, List<Item> savedItems) {
        Optional<Announcement> optionalAnnouncement = announcementRepository.findById(announcementId);

        if (optionalAnnouncement.isPresent()) {
            Announcement announcement = optionalAnnouncement.get();

            // Update the announcement's items
            announcement.setItems(savedItems);

            // Save the updated announcement
            announcementRepository.save(announcement);
        } else {
            throw new IllegalArgumentException("Announcement with ID " + announcementId + " not found.");
        }
    }
}
