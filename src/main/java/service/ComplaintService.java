package service;

import java.util.ArrayList;
import java.util.List;

import model.Complaint;
import model.ComplaintHistory;
import model.ComplaintStatus;
import repository.ComplaintRepository;

public class ComplaintService {

    private ComplaintRepository repository = new ComplaintRepository();

    public void logComplaint(Complaint complaint) {
        repository.save(complaint);
    }

    public void assignComplaint(int id, String handler) {
        Complaint complaint = repository.findById(id);
        if (complaint == null) {
            System.out.println("Complaint not found");
            return;
        }

        if (complaint.getStatus() != ComplaintStatus.OPEN) {
            System.out.println("Complaint cannot be assigned in current state");
            return;
        }

        complaint.setHandler(handler);
        complaint.setStatus(ComplaintStatus.IN_PROGRESS);
        complaint.addHistory("ASSIGNED to " + handler);
    }

    public void resolveComplaint(int id) {
        Complaint complaint = repository.findById(id);
        if (complaint == null) {
            System.out.println("Complaint not found");
            return;
        }

        if (complaint.getStatus() != ComplaintStatus.IN_PROGRESS) {
            System.out.println("Only IN_PROGRESS complaints can be resolved");
            return;
        }

        complaint.setStatus(ComplaintStatus.RESOLVED);
        complaint.addHistory("RESOLVED");
    }

    public void closeComplaint(int id) {
        Complaint complaint = repository.findById(id);
        if (complaint == null) {
            System.out.println("Complaint not found");
            return;
        }

        if (complaint.getStatus() != ComplaintStatus.RESOLVED) {
            System.out.println("Only RESOLVED complaints can be closed");
            return;
        }

        complaint.setStatus(ComplaintStatus.CLOSED);
        complaint.addHistory("CLOSED");
    }

    public void displayComplaints() {
        List<Complaint> complaints = repository.findAll();

        for (Complaint c : complaints) {
            System.out.println(c);
            for (ComplaintHistory h : c.getHistory()) {
                System.out.println("  - " + h.getAction() + " at " + h.getTimestamp());
            }
        }
    }
}
