import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;
    String email;

    // Constructor to create a new contact
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Method to display contact details
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
    }
}

public class ContactManagementSystem {

    // List to store contacts
    private static ArrayList<Contact> contacts = new ArrayList<>();

    // Method to add a new contact
    public static void addContact(String name, String phoneNumber, String email) {
        Contact newContact = new Contact(name, phoneNumber, email);
        contacts.add(newContact);
        System.out.println("Contact added successfully.");
    }

    // Method to view all contacts
    public static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println("\nContact " + (i + 1) + ":");
                contacts.get(i).display();
            }
        }
    }

    // Method to update an existing contact
    public static void updateContact(int index, String name, String phoneNumber, String email) {
        if (index >= 0 && index < contacts.size()) {
            Contact contactToUpdate = contacts.get(index);
            contactToUpdate.name = name;
            contactToUpdate.phoneNumber = phoneNumber;
            contactToUpdate.email = email;
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Method to delete a contact
    public static void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Contact Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // Add Contact
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String email = scanner.nextLine();
                    addContact(name, phoneNumber, email);
                    break;

                case 2: // View Contacts
                    viewContacts();
                    break;

                case 3: // Update Contact
                    System.out.print("Enter the contact index to update (starting from 0): ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhone = scanner.nextLine();
                    System.out.print("Enter new email address: ");
                    String newEmail = scanner.nextLine();
                    updateContact(updateIndex, newName, newPhone, newEmail);
                    break;

                case 4: // Delete Contact
                    System.out.print("Enter the contact index to delete (starting from 0): ");
                    int deleteIndex = scanner.nextInt();
                    deleteContact(deleteIndex);
                    break;

                case 5: // Exit
                    System.out.println("Exiting the Contact Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
