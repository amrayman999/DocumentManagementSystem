package Package_2;

import Package_1.Document;
import java.util.List;
import java.util.Scanner;

public class Email extends Document {
    private static final int MAX_BODY_LENGTH = 1000;
    private String[] recipients;
    private String subject;
    private String body;

    public Email(String name, String folderpath, String topicName, int topicId, String creation_date, List<String> tags, String[] recipients, String subject, String body) {
        super(name, folderpath, topicName, topicId, creation_date, tags);
        this.recipients = recipients;
        this.subject = subject;
        setBody(body);
    }

    public String[] getRecipients() {
        return recipients.clone();
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        if (body.length() > MAX_BODY_LENGTH) {
            throw new IllegalArgumentException("Body length exceeds the maximum allowed length of " + MAX_BODY_LENGTH + " characters.");
        }
        this.body = body;
    }

    public void validateBodyLength() throws LengthOverFlowException {
        int difference = MAX_BODY_LENGTH - body.length();
        if (difference < 0) {
            throw new LengthOverFlowException("The body's length exceeded the specified length", Math.abs(difference));
        }
    }

    @Override
    public void ADD_data() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email name: ");
        this.Name = scanner.nextLine();

        System.out.print("Enter folder path: ");
        this.storagefolderpath = scanner.nextLine();

        System.out.print("Enter topic name: ");
        String topicName = scanner.nextLine();

        System.out.print("Enter topic ID: ");
        int topicId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter tags (comma-separated): ");
        String tagsInput = scanner.nextLine();
        this.tags = List.of(tagsInput.split(",\\s*"));

        System.out.print("Enter recipients (comma-separated): ");
        String recipientInput = scanner.nextLine();
        this.recipients = recipientInput.split(",\\s*");

        System.out.print("Enter subject: ");
        this.subject = scanner.nextLine();

        System.out.print("Enter body (max " + MAX_BODY_LENGTH + " characters): ");
        this.body = scanner.nextLine();

        try {
            validateBodyLength();
            System.out.println("Email data added successfully.");
        } catch (LengthOverFlowException e) {
            System.out.println(e.getMessage() + " Exceeded by: " + e.getExceededLengthAmount() + " characters.");
        }
    }

    @Override
    public void Display_data() {
        System.out.println("Email Name: " + this.Name);
        System.out.println("Folder Path: " + this.storagefolderpath);
        System.out.println("Topic Name: " + getTopicName());
        System.out.println("Topic ID: " + getTopicId());
        System.out.println("Creation Date: " + this.creationDate);
        System.out.println("Tags: " + String.join(", ", this.tags));
        System.out.println("Recipients: " + String.join(", ", recipients));
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }

    @Override
    public void Edit_data() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Update subject for the email: ");
        this.subject = scanner.nextLine();

        System.out.print("Update body for the email (max " + MAX_BODY_LENGTH + " characters): ");
        String bodyInput = scanner.nextLine();
        setBody(bodyInput);

        System.out.print("Update recipients (comma-separated): ");
        String recipientInput = scanner.nextLine();
        this.recipients = recipientInput.split(",\\s*");

        try {
            validateBodyLength();
        } catch (LengthOverFlowException e) {
            System.out.println(e.getMessage() + " Exceeded by: " + e.getExceededLengthAmount() + " characters.");
        }

        System.out.println("Email data updated successfully.");
    }

    @Override
    public void Delete() {
        System.out.println("Email '" + this.Name + "' has been deleted.");
    }
}
