package service;

import model.Complaint;
import repository.ComplaintRepository;
import java.util.List;

public class ComplaintService {

    private ComplaintRepository repository;

    public ComplaintService() {
        repository = new ComplaintRepository();
    }

    public void logComplaint(Complaint complaint) {
        repository.save(complaint);
    }

    public void assignComplaint(int id, String handler) {
        Complaint complaint = repository.findById(id);
        if (complaint != null) {
            complaint.assignHandler(handler);
        }
    }

    public void resolveComplaint(int id) {
        Complaint complaint = repository.findById(id);
        if (complaint != null) {
            complaint.resolve();
        }
    }

    public void closeComplaint(int id) {
        Complaint complaint = repository.findById(id);
        if (complaint != null) {
            complaint.close();
        }
    }

    public void displayComplaints() {
        for (Complaint c : repository.findAll()) {
            System.out.println(c);
        }
    }
    public List<Complaint> getAllComplaints() {
    return repository.findAll();
}
}

