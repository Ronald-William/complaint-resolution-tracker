package service;

import model.Complaint;
import repository.ComplaintRepository;

public class ComplaintService {

    private ComplaintRepository repository = new ComplaintRepository();

    public void logComplaint(Complaint complaint) {
        repository.save(complaint);
    }

    public void assignComplaint(int complaintId, String handler) {
        Complaint complaint = repository.findById(complaintId);
        if (complaint != null) {
            complaint.assignTo(handler);
        }
    }

    public void displayComplaints() {
        repository.findAll().forEach(System.out::println);
    }
}
