//TASK 3

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;
    String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email Address: " + emailAddress;
    }
}

public class management {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add a new contact");
            System.out.println("2. View contact list");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContactList();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber, emailAddress);
        contacts.add(newContact);

        System.out.println("Contact added successfully.");
    }

    private static void viewContactList() {
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("Contact List:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private static void editContact() {
        viewContactList();

        System.out.print("Enter the index of the contact to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (index >= 0 && index < contacts.size()) {
            Contact contactToEdit = contacts.get(index);

            System.out.print("Enter new name (press Enter to keep the current name): ");
            String newName = scanner.nextLine();
            contactToEdit.name = newName.isEmpty() ? contactToEdit.name : newName;

            System.out.print("Enter new phone number (press Enter to keep the current phone number): ");
            String newPhoneNumber = scanner.nextLine();
            contactToEdit.phoneNumber = newPhoneNumber.isEmpty() ? contactToEdit.phoneNumber : newPhoneNumber;

            System.out.print("Enter new email address (press Enter to keep the current email address): ");
            String newEmailAddress = scanner.nextLine();
            contactToEdit.emailAddress = newEmailAddress.isEmpty() ? contactToEdit.emailAddress : newEmailAddress;

            System.out.println("Contact edited successfully.");
        } else {
            System.out.println("Invalid index. No contact found at the specified index.");
        }
    }

    private static void deleteContact() {
        viewContactList();

        System.out.print("Enter the index of the contact to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (index >= 0 && index < contacts.size()) {
            Contact deletedContact = contacts.remove(index);
            System.out.println("Contact deleted successfully: " + deletedContact);
        } else {
            System.out.println("Invalid index. No contact found at the specified index.");
        }
    }
}
