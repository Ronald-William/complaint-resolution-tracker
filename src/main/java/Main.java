import model.Complaint;
import service.ComplaintService;

public class Main {

    public static void main(String[] args) throws Exception {

        ComplaintService service = new ComplaintService();

        Complaint c1 = new Complaint(1, "Internet", "No connectivity");
        service.logComplaint(c1);

        service.assignComplaint(1, "John-Handler");
        service.resolveComplaint(1);
        service.closeComplaint(1);

        service.getAllComplaints()
               .forEach(System.out::println);
    }
}
