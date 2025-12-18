package service;

import dao.ComplaintDAO;
import model.Complaint;
import model.ComplaintStatus;

import java.sql.SQLException;
import java.util.List;

public class ComplaintService {

    private ComplaintDAO dao = new ComplaintDAO();

    public void logComplaint(Complaint complaint) throws SQLException {
        dao.createComplaint(complaint);
    }

    public void assignComplaint(int id, String handler) throws SQLException {
        dao.updateStatus(id, ComplaintStatus.IN_PROGRESS);
    }

    public void resolveComplaint(int id) throws SQLException {
        dao.updateStatus(id, ComplaintStatus.RESOLVED);
    }

    public void closeComplaint(int id) throws SQLException {
        dao.updateStatus(id, ComplaintStatus.CLOSED);
    }

    public List<Complaint> getAllComplaints() throws SQLException {
        return dao.getAllComplaints();
    }
}
