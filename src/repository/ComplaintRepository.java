package repository;

import model.Complaint;
import java.util.ArrayList;
import java.util.List;

public class ComplaintRepository {
    private final List<Complaint> complaints = new ArrayList<>();

    public void save(Complaint complaint) {
        complaints.add(complaint);
    }

    public List<Complaint> findAll() {
        return complaints;
    }
}
