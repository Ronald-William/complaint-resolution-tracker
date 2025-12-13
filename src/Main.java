import repository.ComplaintRepository;
import service.ComplaintService;
import model.Complaint;

public class Main {
    public static void main(String[] args) {

        ComplaintRepository repository = new ComplaintRepository();
        ComplaintService service = new ComplaintService(repository);

        Complaint c1 = service.logComplaint(
                "Electricity",
                "Power outage in room 204"
        );

        Complaint c2 = service.logComplaint(
                "Plumbing",
                "Water leakage in bathroom"
        );

        System.out.println(c1);
        System.out.println(c2);
    }
}
