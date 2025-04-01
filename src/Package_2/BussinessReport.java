package Package_2;

import Package_1.Document;
import java.util.List;
import java.util.Scanner;

public class BussinessReport extends Document {
    private String[] recipients;
    private String text;
    private String imageFormat;

    public BussinessReport(String name, String folderpath, String topicName, int topicId, String creation_date, List<String> tags, String[] recipients, String text, String imageFormat) {
        super(name, folderpath, topicName, topicId, creation_date, tags);
        this.recipients = recipients;
        this.text = text;
        this.imageFormat = imageFormat;
    }

    public String[] getRecipients() {
        return recipients.clone();
    }

    public String getText() {
        return text;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        if (!isValidImageFormat(imageFormat)) {
            throw new IllegalArgumentException("Invalid image format. Allowed formats are: JPEG, PNG, GIF, PDF.");
        }
        this.imageFormat = imageFormat;
    }

    private boolean isValidImageFormat(String format) {
        return format.equals("JPEG") || format.equals("PNG") || format.equals("GIF") || format.equals("PDF");
    }

    @Override
    public void ADD_data() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter business report name: ");
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

        System.out.print("Enter text for the business report: ");
        this.text = scanner.nextLine();

        System.out.print("Enter image format (JPEG, PNG, GIF, PDF): ");
        String format = scanner.nextLine();
        setImageFormat(format);

        System.out.println("Business report data added successfully.");
    }

    @Override
    public void Display_data() {
        System.out.println("Business Report Name: " + this.Name);
        System.out.println("Folder Path: " + this.storagefolderpath);
        System.out.println("Topic Name: " + getTopicName());
        System.out.println("Topic ID: " + getTopicId());
        System.out.println("Creation Date: " + this.creationDate);
        System.out.println("Tags: " + String.join(", ", this.tags));
        System.out.println("Recipients: " + String.join(", ", recipients));
        System.out.println("Text: " + text);
        System.out.println("Image Format: " + imageFormat);
    }

    @Override
    public void Edit_data() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Update text for the business report: ");
        this.text = scanner.nextLine();

        System.out.print("Update image format (JPEG, PNG, GIF, PDF): ");
        String format = scanner.nextLine();
        setImageFormat(format);

        System.out.print("Update recipients (comma-separated): ");
        String recipientInput = scanner.nextLine();
        this.recipients = recipientInput.split(",\\s*");

        System.out.println("Business report data updated successfully.");
    }

    @Override
    public void Delete() {
        System.out.println("Business Report '" + this.Name + "' has been deleted.");
    }
}
