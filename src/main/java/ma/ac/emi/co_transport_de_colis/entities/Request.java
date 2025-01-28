package ma.ac.emi.co_transport_de_colis.entities;

import ma.ac.emi.co_transport_de_colis.Enums.RequestStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "request")
public class Request {
    @Id
    private String id;
    private String announcementId;
    private String driverId;
    private String customerId;
    private RequestStatus status = RequestStatus.PENDING;

    public Request(String announcementId, String driverId, String customerId , RequestStatus status) {
        this.announcementId = announcementId;
        this.driverId = driverId;
        this.customerId = customerId;
        this.status = status;
    }

    public Request() {
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getAnnouncementId() {
        return announcementId;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
