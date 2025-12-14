import model.Complaint;
import service.ComplaintService;

public class Main {
    public static void main(String[] args) {
        ComplaintService service = new ComplaintService();

        Complaint c1 = new Complaint(1, "Internet", "No connectivity");
        service.logComplaint(c1);

        service.assignComplaint(1, "John-Handler");

        service.displayComplaints();
    }
}
