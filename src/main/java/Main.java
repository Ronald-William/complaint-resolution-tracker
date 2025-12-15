import java.util.Scanner;
import model.Complaint;
import service.ComplaintService;

public class Main {

    private static final String ADMIN_PASSWORD = "admin123";
    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ComplaintService service = new ComplaintService();

        boolean running = true;

        while (running) {
            System.out.println("\n=== COMPLAINT RESOLUTION SYSTEM ===");
            System.out.println("1. User");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            System.out.print("Choose role: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> userMenu(sc, service);
                case 2 -> {
                    if (authenticateAdmin(sc)) {
                        adminMenu(sc, service);
                    } else {
                        System.out.println("Access denied. Returning to main menu.");
                    }
                }
                case 3 -> {
                    running = false;
                    System.out.println("Exiting system...");
                }
                default -> System.out.println("Invalid option.");
            }
        }
        sc.close();
    }

    private static boolean authenticateAdmin(Scanner sc) {

        for (int i = 1; i <= MAX_ATTEMPTS; i++) {
            System.out.print("Enter admin password: ");
            String input = sc.nextLine();

            if (ADMIN_PASSWORD.equals(input)) {
                System.out.println("Admin authenticated successfully.");
                return true;
            } else {
                System.out.println("Incorrect password (" + i + "/" + MAX_ATTEMPTS + ")");
            }
        }
        return false;
    }

    private static void userMenu(Scanner sc, ComplaintService service) {

        System.out.println("\n--- USER MENU ---");
        System.out.print("Enter Complaint ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Description: ");
        String description = sc.nextLine();

        Complaint complaint = new Complaint(id, category, description);
        service.logComplaint(complaint);

        System.out.println("Complaint logged successfully.");
    }

    private static void adminMenu(Scanner sc, ComplaintService service) {

        boolean adminRunning = true;

        while (adminRunning) {
            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. Assign Complaint");
            System.out.println("2. Resolve Complaint");
            System.out.println("3. Close Complaint");
            System.out.println("4. View All Complaints");
            System.out.println("5. Back");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Complaint ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Handler Name: ");
                    String handler = sc.nextLine();
                    service.assignComplaint(id, handler);
                }
                case 2 -> {
                    System.out.print("Enter Complaint ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    service.resolveComplaint(id);
                }
                case 3 -> {
                    System.out.print("Enter Complaint ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    service.closeComplaint(id);
                }
                case 4 -> service.displayComplaints();
                case 5 -> adminRunning = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
