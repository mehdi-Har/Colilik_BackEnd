package ma.ac.emi.co_transport_de_colis.controllers;

import ma.ac.emi.co_transport_de_colis.entities.Announcement;
import ma.ac.emi.co_transport_de_colis.entities.DriverProposal;
import ma.ac.emi.co_transport_de_colis.services.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

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

    @PostMapping("/{announcementId}/proposals")
    public Announcement addProposal(@PathVariable String announcementId, @RequestBody DriverProposal proposal) {
        return announcementService.addProposal(announcementId, proposal);
    }

    @GetMapping("/{announcementId}/proposals")
    public List<DriverProposal> getProposals(@PathVariable String announcementId) {
        return announcementService.getProposals(announcementId);
    }

}

