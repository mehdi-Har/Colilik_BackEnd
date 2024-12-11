package ma.ac.emi.co_transport_de_colis.entities;

import java.time.LocalDateTime;

public class DriverProposal {

    private String driverId;
    private double proposedPrice;
    private LocalDateTime proposalTimestamp;

    public DriverProposal(String driverId, double proposedPrice, LocalDateTime proposalTimestamp) {
        this.setDriverId(driverId);
        this.setProposedPrice(proposedPrice);
        this.setProposalTimestamp(proposalTimestamp);
    }
    public DriverProposal() {}

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public double getProposedPrice() {
        return proposedPrice;
    }

    public void setProposedPrice(double proposedPrice) {
        this.proposedPrice = proposedPrice;
    }

    public LocalDateTime getProposalTimestamp() {
        return proposalTimestamp;
    }

    public void setProposalTimestamp(LocalDateTime proposalTimestamp) {
        this.proposalTimestamp = proposalTimestamp;
    }
}
