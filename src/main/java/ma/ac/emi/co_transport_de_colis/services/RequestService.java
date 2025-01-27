package ma.ac.emi.co_transport_de_colis.services;

import ma.ac.emi.co_transport_de_colis.entities.Request;
import ma.ac.emi.co_transport_de_colis.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public Request createRequest(Request req) {
        return requestRepository.save(req);
    }

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Optional<Request> getRequestById(String idRequest) {
        return requestRepository.findById(idRequest);
    }

    public void deleteRequest(String idRequest) {
        requestRepository.deleteById(idRequest);
    }
    public void saveRequest(Request request) {
        requestRepository.save(request);
    }
}
