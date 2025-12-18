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
            Complaint c = new Complaint(
                    rs.getInt("id"),
                    rs.getString("category"),
                    rs.getString("description")
            );
            c.assignHandler(rs.getString("handler"));
            c.setStatus(ComplaintStatus.valueOf(rs.getString("status")));
            complaints.add(c);
        }

        return complaints;
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
