package service;

import org.junit.jupiter.api.Test;
import service.ComplaintService;
import model.Complaint;

import static org.junit.jupiter.api.Assertions.*;

public class ComplaintServiceTest {

    @Test
    void testLogComplaint() throws Exception {

        ComplaintService service = new ComplaintService();
        Complaint c = new Complaint(100, "Network", "Slow speed");

        service.logComplaint(c);

        assertFalse(service.getAllComplaints().isEmpty());
    }
}
