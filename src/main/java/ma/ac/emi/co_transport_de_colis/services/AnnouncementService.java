package ma.ac.emi.co_transport_de_colis.services;

import ma.ac.emi.co_transport_de_colis.entities.Announcement;
import ma.ac.emi.co_transport_de_colis.entities.DriverProposal;
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
                    announcement.setDescription(updatedAnnouncement.getDescription());
                    announcement.setPickUpTime(updatedAnnouncement.getPickUpTime());
                    announcement.setDropUpFrom(updatedAnnouncement.getDropUpFrom());
                    announcement.setDropTo(updatedAnnouncement.getDropTo());
                    announcement.setDeliveryTime(updatedAnnouncement.getDeliveryTime());
                    announcement.setDriverProposals(updatedAnnouncement.getDriverProposals());
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
    public Announcement addProposal(String announcementId, DriverProposal proposal) {
        Announcement announcement = announcementRepository.findById(announcementId)
                .orElseThrow(() -> new RuntimeException("Annoncement not found "));

        announcement.getDriverProposals().add(proposal);
        return announcementRepository.save(announcement);
    }

    public List<DriverProposal> getProposals(String announcementId) {
        Announcement announcement = announcementRepository.findById(announcementId)
                .orElseThrow(() -> new RuntimeException("Annoncement not found "));

        return announcement.getDriverProposals();
    }

    public Announcement markAnnouncementAsCompleted(String announcementId) {
        Announcement announcement = announcementRepository.findById(announcementId)
                .orElseThrow(() -> new RuntimeException("Annoncement not found "));

        announcement.setStatus(true);
        return announcementRepository.save(announcement);
    }
}
