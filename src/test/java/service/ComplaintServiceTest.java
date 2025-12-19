package service;

import model.Complaint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComplaintServiceTest {

    @Test
    void testLogComplaint() throws Exception {

        ComplaintService service = new ComplaintService();

        Complaint c = new Complaint("Network", "Slow speed");
        service.logComplaint(c);

        assertTrue(service.getAllComplaints().size() > 0);
    }
}
