package ma.ac.emi.co_transport_de_colis.controllers;

import ma.ac.emi.co_transport_de_colis.entities.Request;
import ma.ac.emi.co_transport_de_colis.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;


    @GetMapping
    public List<Request> getAllRequests() {
        return requestService.getAllRequests();
    }

    @GetMapping("/{idRequest}")
    public Optional<Request> getRequestById(@PathVariable String idRequest) {
        return requestService.getRequestById(idRequest);
    }


    @DeleteMapping("/{idRequest}")
    public void deleteRequest(@PathVariable String idRequest) {
        requestService.deleteRequest(idRequest);
    }
    @PostMapping
    public ResponseEntity<?> createRequests(@RequestBody List<Request> requests) {
        for (Request request : requests) {
            requestService.saveRequest(request);
        }
        return ResponseEntity.ok("Requests created successfully");
    }

}
