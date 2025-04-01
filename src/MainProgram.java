import Package_2.Email;
import Package_2.BussinessReport;
import Package_2.LengthOverFlowException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Email> emails = new ArrayList<>();
        List<BussinessReport> reports = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Document Management System ---");
            System.out.println("1. Create Email");
            System.out.println("2. Create Business Report");
            System.out.println("3. Edit Email");
            System.out.println("4. Edit Business Report");
            System.out.println("5. Display Emails");
            System.out.println("6. Display Business Reports");
            System.out.println("7. Delete Document");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // Create Email
                    Email email = new Email("", "", "", 0, getCurrentDateTime(), new ArrayList<>(), new String[]{}, "", "");
                    email.ADD_data();
                    emails.add(email);
                    break;

                case 2:
                    // Create Business Report
                    BussinessReport report = new BussinessReport("", "", "", 0, getCurrentDateTime(), new ArrayList<>(), new String[]{}, "", "");
                    report.ADD_data();
                    reports.add(report);
                    break;

                case 3:
                    // Edit Email
                    if (emails.isEmpty()) {
                        System.out.println("No emails available to edit.");
                    } else {
                        System.out.println("Select an email to edit:");
                        for (int i = 0; i < emails.size(); i++) {
                            System.out.println((i + 1) + ". " + emails.get(i).getSubject());
                        }
                        int emailIndex = scanner.nextInt() - 1;
                        scanner.nextLine(); 
                        if (emailIndex >= 0 && emailIndex < emails.size()) {
                            emails.get(emailIndex).Edit_data();
                        } else {
                            System.out.println("Invalid selection.");
                        }
                    }
                    break;

                case 4:
                    // Edit Business Report
                    if (reports.isEmpty()) {
                        System.out.println("No business reports available to edit.");
                    } else {
                        System.out.println("Select a business report to edit:");
                        for (int i = 0; i < reports.size(); i++) {
                            System.out.println((i + 1) + ". " + reports.get(i).getText());
                        }
                        int reportIndex = scanner.nextInt() - 1;
                        scanner.nextLine(); 
                        if (reportIndex >= 0 && reportIndex < reports.size()) {
                            reports.get(reportIndex).Edit_data();
                        } else {
                            System.out.println("Invalid selection.");
                        }
                    }
                    break;

                case 5:
                    // Display Emails
                    if (emails.isEmpty()) {
                        System.out.println("No emails to display.");
                    } else {
                        for (Email e : emails) {
                            e.Display_data();
                        }
                    }
                    break;

                case 6:
                    // Display Business Reports
                    if (reports.isEmpty()) {
                        System.out.println("No business reports to display.");
                    } else {
                        for (BussinessReport r : reports) {
                            r.Display_data();
                        }
                    }
                    break;

                case 7:
                    // Delete Document
                    deleteDocument(scanner, emails, reports);
                    break;

                case 8:
                    // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void deleteDocument(Scanner scanner, List<Email> emails, List<BussinessReport> reports) {
        System.out.println("Select the type of document to delete:");
        System.out.println("1. Email");
        System.out.println("2. Business Report");
        int typeChoice = scanner.nextInt();
        scanner.nextLine(); 
        switch (typeChoice) {
            case 1:
                if (emails.isEmpty()) {
                    System.out.println("No emails available to delete.");
                } else {
                    System.out.println("Select an email to delete:");
                    for (int i = 0; i < emails.size(); i++) {
                        System.out.println((i + 1) + ". " + emails.get(i).getSubject());
                    }
                    int emailIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); 
                    if (emailIndex >= 0 && emailIndex < emails.size()) {
                        emails.get(emailIndex).Delete();
                        emails.remove(emailIndex);
                        System.out.println("Email deleted successfully.");
                    } else {
                        System.out.println("Invalid selection.");
                    }
                }
                break;

            case 2:
                if (reports.isEmpty()) {
                    System.out.println("No business reports available to delete.");
                } else {
                    System.out.println("Select a business report to delete:");
                    for (int i = 0; i < reports.size(); i++) {
                        System.out.println((i + 1) + ". " + reports.get(i).getText());
                    }
                    int reportIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); 
                    if (reportIndex >= 0 && reportIndex < reports.size()) {
                        reports.get(reportIndex).Delete();
                        reports.remove(reportIndex);
                        System.out.println("Business report deleted successfully.");
                    } else {
                        System.out.println("Invalid selection.");
                    }
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    private static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}