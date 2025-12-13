package service;

import model.Complaint;
import repository.ComplaintRepository;

public class ComplaintService {
    private final ComplaintRepository repository;
    private int idCounter = 1;

    public ComplaintService(ComplaintRepository repository) {
        this.repository = repository;
    }

    public Complaint logComplaint(String category, String description) {
        Complaint complaint = new Complaint(idCounter++, category, description);
        repository.save(complaint);
        return complaint;
    }
}
