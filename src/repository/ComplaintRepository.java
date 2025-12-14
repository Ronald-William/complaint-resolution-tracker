package repository;

import model.Complaint;
import java.util.ArrayList;
import java.util.List;

public class ComplaintRepository {

    private List<Complaint> complaints = new ArrayList<>();

    public void save(Complaint complaint) {
        complaints.add(complaint);
    }

    public Complaint findById(int id) {
        for (Complaint c : complaints) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public List<Complaint> findAll() {
        return complaints;
    }
}
