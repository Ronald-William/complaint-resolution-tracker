import service.ComplaintService;
import model.Complaint;

import java.util.Scanner;

public class Main {

    private static final String ADMIN_PASSWORD = "admin123";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ComplaintService service = new ComplaintService();

        System.out.println("Select Role:");
        System.out.println("1. User");
        System.out.println("2. Admin");
        int role = sc.nextInt();
        sc.nextLine();

        boolean isAdmin = role == 2;

        if (isAdmin) {
            System.out.print("Enter admin password: ");
            String password = sc.nextLine();

            if (!ADMIN_PASSWORD.equals(password)) {
                System.out.println("Invalid admin password");
                return;
            }
        }

        while (true) {
            System.out.println("\nMenu:");

            if (!isAdmin) {
                System.out.println("1. Log Complaint");
                System.out.println("2. View Complaints");
                System.out.println("3. Exit");
            } else {
                System.out.println("1. View Complaints");
                System.out.println("2. Assign Handler");
                System.out.println("3. Resolve Complaint");
                System.out.println("4. Close Complaint");
                System.out.println("5. Exit");
            }

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                if (!isAdmin) {
                    switch (choice) {
                        case 1:
                            System.out.print("Category: ");
                            String category = sc.nextLine();

                            System.out.print("Description: ");
                            String description = sc.nextLine();

                            Complaint complaint = new Complaint(category, description);
                            service.logComplaint(complaint);

                            System.out.println("Complaint logged successfully");
                            break;

                        case 2:
                            service.displayComplaints();
                            break;

                        case 3:
                            System.exit(0);

                        default:
                            System.out.println("Invalid option");
                    }
                } else {
                    switch (choice) {
                        case 1:
                            service.displayComplaints();
                            break;

                        case 2:
                            System.out.print("Complaint ID: ");
                            int assignId = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Handler Name: ");
                            String handler = sc.nextLine();

                            service.assignComplaint(assignId, handler);
                            System.out.println("Handler assigned");
                            break;

                        case 3:
                            System.out.print("Complaint ID: ");
                            int resolveId = sc.nextInt();
                            sc.nextLine();

                            service.resolveComplaint(resolveId);
                            System.out.println("Complaint resolved");
                            break;

                        case 4:
                            System.out.print("Complaint ID: ");
                            int closeId = sc.nextInt();
                            sc.nextLine();

                            service.closeComplaint(closeId);
                            System.out.println("Complaint closed");
                            break;

                        case 5:
                            System.exit(0);

                        default:
                            System.out.println("Invalid option");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
