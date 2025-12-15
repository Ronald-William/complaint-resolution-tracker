package service;

import model.Complaint;
import model.ComplaintStatus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ComplaintServiceTest {

    @Test
    void testLogComplaint() {
        ComplaintService service = new ComplaintService();
        Complaint c = new Complaint(1, "Internet", "No connectivity");

        service.logComplaint(c);

        assertEquals(1, service.getAllComplaints().size());
        assertEquals(ComplaintStatus.OPEN, service.getAllComplaints().get(0).getStatus());
    }

    @Test
    void testAssignComplaint() {
        ComplaintService service = new ComplaintService();
        Complaint c = new Complaint(2, "Electricity", "Power cut");

        service.logComplaint(c);
        service.assignComplaint(2, "Admin-User");

        Complaint updated = service.getAllComplaints().get(0);
        assertEquals(ComplaintStatus.IN_PROGRESS, updated.getStatus());
    }

    @Test
    void testResolveComplaint() {
        ComplaintService service = new ComplaintService();
        Complaint c = new Complaint(3, "Water", "Leakage");

        service.logComplaint(c);
        service.assignComplaint(3, "Handler");
        service.resolveComplaint(3);

        Complaint updated = service.getAllComplaints().get(0);
        assertEquals(ComplaintStatus.RESOLVED, updated.getStatus());
    }

    @Test
    void testCloseComplaint() {
        ComplaintService service = new ComplaintService();
        Complaint c = new Complaint(4, "Road", "Potholes");

        service.logComplaint(c);
        service.assignComplaint(4, "Handler");
        service.resolveComplaint(4);
        service.closeComplaint(4);

        Complaint updated = service.getAllComplaints().get(0);
        assertEquals(ComplaintStatus.CLOSED, updated.getStatus());
    }
}
