package dao;

import db.DatabaseConnection;
import model.Complaint;
import model.ComplaintStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDAO {

    public void createComplaint(Complaint complaint) throws SQLException {
        String sql = "INSERT INTO complaints (category, description, handler, status) VALUES (?, ?, ?, ?)";
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, complaint.getCategory());
        ps.setString(2, complaint.getDescription());
        ps.setString(3, complaint.getHandler());
        ps.setString(4, complaint.getStatus().name());

        ps.executeUpdate();
    }

    public List<Complaint> getAllComplaints() throws SQLException {
        List<Complaint> complaints = new ArrayList<>();
        String sql = "SELECT * FROM complaints";
        Connection con = DatabaseConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            complaints.add(
                new Complaint(
                    rs.getInt("id"),
                    rs.getString("category"),
                    rs.getString("description"),
                    rs.getString("handler"),
                    ComplaintStatus.valueOf(rs.getString("status"))
                )
            );
        }

        return complaints;
    }

    public void assignHandler(int id, String handler) throws SQLException {
        String sql = "UPDATE complaints SET handler=?, status=? WHERE id=?";
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, handler);
        ps.setString(2, ComplaintStatus.IN_PROGRESS.name());
        ps.setInt(3, id);

        ps.executeUpdate();
    }

    public void updateStatus(int id, ComplaintStatus status) throws SQLException {
        String sql = "UPDATE complaints SET status=? WHERE id=?";
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, status.name());
        ps.setInt(2, id);

        ps.executeUpdate();
    }
}
