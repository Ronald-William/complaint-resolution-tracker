import model.*;
import service.ComplaintService;

public class Main {
    public static void main(String[] args) {

        ComplaintService service = new ComplaintService();

        Actor user = new Actor("Alice", Role.USER);
        Actor admin = new Actor("Bob", Role.ADMIN);
        Actor handler = new Actor("John", Role.HANDLER);

        Complaint c1 = new Complaint(1, "Internet", "No connectivity");

        service.logComplaint(user, c1);
        service.assignComplaint(admin, 1, "John");
        service.resolveComplaint(handler, 1);
        service.closeComplaint(admin, 1);

        service.displayComplaints();
    }
}
