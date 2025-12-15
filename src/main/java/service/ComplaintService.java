package service;

import model.*;
import repository.ComplaintRepository;

public class ComplaintService {

    private ComplaintRepository repository = new ComplaintRepository();

    public void logComplaint(Actor actor, Complaint complaint) {
        if (actor.getRole() != Role.USER) {
            throw new RuntimeException("Only USERS can log complaints");
        }
        repository.save(complaint);
    }

    public void assignComplaint(Actor actor, int complaintId, String handler) {
        if (actor.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only ADMIN can assign complaints");
        }

        Complaint c = repository.findById(complaintId);
        c.assignHandler(handler);
    }

    public void resolveComplaint(Actor actor, int complaintId) {
        if (actor.getRole() != Role.HANDLER) {
            throw new RuntimeException("Only HANDLERS can resolve complaints");
        }

        Complaint c = repository.findById(complaintId);
        c.resolve();
    }

    public void closeComplaint(Actor actor, int complaintId) {
        if (actor.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only ADMIN can close complaints");
        }

        Complaint c = repository.findById(complaintId);
        c.close();
    }

    public void displayComplaints() {
        repository.findAll().forEach(System.out::println);
    }
}
