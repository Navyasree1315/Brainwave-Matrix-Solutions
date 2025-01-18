package brainwaveinternship;

import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagementSystem {
    private static Scanner sc = new Scanner(System.in);

    // Main menu
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n* * * * * Hospital Management System * * * * *");
            System.out.println("1. Patient Management");
            System.out.println("2. Appointment Management");
            System.out.println("3. Electronic Health Records (EHR)");
            System.out.println("4. Billing Management");
            System.out.println("5. Inventory Management");
            System.out.println("6. Staff Management");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    PatientManager.menu();
                    break;
                case 2:
                    AppointmentManager.menu();
                    break;
                case 3:
                    EHRManager.menu();
                    break;
                case 4:
                    BillingManager.menu();
                    break;
                case 5:
                    InventoryManager.menu();
                    break;
                case 6:
                    StaffManager.menu();
                    break;
                case 7:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // PatientManager Class
    static class PatientManager {
        static ArrayList<Patient> patients = new ArrayList<>();

        static void menu() {
            while (true) {
                System.out.println("\n* * * Patient Management * * *");
                System.out.println("1. Add Patient");
                System.out.println("2. View Patients");
                System.out.println("3. Back to Main Menu");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        registerPatient();
                        break;
                    case 2:
                        viewPatients();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }

        static void registerPatient() {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter gender: ");
            String gender = sc.nextLine();
            patients.add(new Patient(name, age, gender));
            System.out.println("Patient registered successfully.");
        }

        static void viewPatients() {
            if (patients.isEmpty()) {
                System.out.println("No patients registered.");
                return;
            }
            System.out.println("\n* * * Registered Patients * * *");
            for (int i = 0; i < patients.size(); i++) {
                System.out.println((i + 1) + ". " + patients.get(i));
            }
        }

        static class Patient {
            String name;
            int age;
            String gender;

            Patient(String name, int age, String gender) {
                this.name = name;
                this.age = age;
                this.gender = gender;
            }

            public String toString() {
                return "Name: " + name + ", Age: " + age + ", Gender: " + gender;
            }
        }
    }

    // AppointmentManager Class
    static class AppointmentManager {
        static ArrayList<Appointment> appointments = new ArrayList<>();

        static void menu() {
            while (true) {
                System.out.println("\n* * * Appointment Management * * *");
                System.out.println("1. Book Appointment");
                System.out.println("2. View Appointments");
                System.out.println("3. Back to Main Menu");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        bookAppointment();
                        break;
                    case 2:
                        viewAppointments();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }

        static void bookAppointment() {
            System.out.print("Enter patient name: ");
            String patientName = sc.nextLine();
            System.out.print("Enter doctor name: ");
            String doctorName = sc.nextLine();
            System.out.print("Enter date (DD/MM/YYYY): ");
            String date = sc.nextLine();
            appointments.add(new Appointment(patientName, doctorName, date));
            System.out.println("Appointment booked successfully.");
        }

        static void viewAppointments() {
            if (appointments.isEmpty()) {
                System.out.println("No appointments scheduled.");
                return;
            }
            System.out.println("\n* * * Appointments * * *");
            for (int i = 0; i < appointments.size(); i++) {
                System.out.println((i + 1) + ". " + appointments.get(i));
            }
        }

        static class Appointment {
            String patientName;
            String doctorName;
            String date;

            Appointment(String patientName, String doctorName, String date) {
                this.patientName = patientName;
                this.doctorName = doctorName;
                this.date = date;
            }

            public String toString() {
                return "Patient: " + patientName + ", Doctor: " + doctorName + ", Date: " + date;
            }
        }
    }

    // Electronic Health Records (EHR)
    static class EHRManager {
        static ArrayList<EHR> ehrRecords = new ArrayList<>();

        static void menu() {
            while (true) {
                System.out.println("\n* * * Electronic Health Records * * *");
                System.out.println("1. Add Record");
                System.out.println("2. View Records");
                System.out.println("3. Back to Main Menu");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addRecord();
                        break;
                    case 2:
                        viewRecords();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }

        static void addRecord() {
            System.out.print("Enter patient name: ");
            String patientName = sc.nextLine();
            System.out.print("Enter diagnosis: ");
            String diagnosis = sc.nextLine();
            System.out.print("Enter treatment: ");
            String treatment = sc.nextLine();
            ehrRecords.add(new EHR(patientName, diagnosis, treatment));
            System.out.println("Record added successfully.");
        }

        static void viewRecords() {
            if (ehrRecords.isEmpty()) {
                System.out.println("No records available.");
                return;
            }
            System.out.println("\n* * * EHR Records * * *");
            for (int i = 0; i < ehrRecords.size(); i++) {
                System.out.println((i + 1) + ". " + ehrRecords.get(i));
            }
        }

        static class EHR {
            String patientName;
            String diagnosis;
            String treatment;

            EHR(String patientName, String diagnosis, String treatment) {
                this.patientName = patientName;
                this.diagnosis = diagnosis;
                this.treatment = treatment;
            }

            public String toString() {
                return "Patient: " + patientName + ", Diagnosis: " + diagnosis + ", Treatment: " + treatment;
            }
        }
    }

    // BillingManager Class
    static class BillingManager {
        static ArrayList<Bill> bills = new ArrayList<>();

        static void menu() {
            while (true) {
                System.out.println("\n* * * Billing Management * * *");
                System.out.println("1. Create Bill");
                System.out.println("2. View Bills");
                System.out.println("3. Back to Main Menu");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        createBill();
                        break;
                    case 2:
                        viewBills();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }

        static void createBill() {
            System.out.print("Enter patient name: ");
            String patientName = sc.nextLine();
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            bills.add(new Bill(patientName, amount));
            System.out.println("Bill created successfully.");
        }

        static void viewBills() {
            if (bills.isEmpty()) {
                System.out.println("No bills available.");
                return;
            }
            System.out.println("\n* * * Bills * * *");
            for (int i = 0; i < bills.size(); i++) {
                System.out.println((i + 1) + ". " + bills.get(i));
            }
        }

        static class Bill {
            String patientName;
            double amount;

            Bill(String patientName, double amount) {
                this.patientName = patientName;
                this.amount = amount;
            }

            public String toString() {
                return "Patient: " + patientName + ", Amount:₹ " + amount;
            }
        }
    }

    // InventoryManager Class
    static class InventoryManager {
        static ArrayList<InventoryItem> inventory = new ArrayList<>();

        static void menu() {
            while (true) {
                System.out.println("\n* * * Inventory Management * * *");
                System.out.println("1. Add Item");
                System.out.println("2. View Inventory");
                System.out.println("3. Update Stock");
                System.out.println("4. Back to Main Menu");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        viewInventory();
                        break;
                    case 3:
                        updateStock();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }

        static void addItem() {
            System.out.print("Enter item name: ");
            String name = sc.nextLine();
            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            inventory.add(new InventoryItem(name, quantity));
            System.out.println("Item added successfully.");
        }

        static void viewInventory() {
            if (inventory.isEmpty()) {
                System.out.println("Inventory is empty.");
                return;
            }
            System.out.println("\n* * * Inventory * * *");
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println((i + 1) + ". " + inventory.get(i));
            }
        }

        static void updateStock() {
            viewInventory();
            if (inventory.isEmpty()) return;

            System.out.print("Enter item number to update: ");
            int index = sc.nextInt() - 1;
            if (index < 0 || index >= inventory.size()) {
                System.out.println("Invalid item number.");

                return;
            }
            System.out.print("Enter new quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            inventory.get(index).quantity = quantity;
            System.out.println("Stock updated successfully.");
        }

        static class InventoryItem {
            String name;
            int quantity;

            InventoryItem(String name, int quantity) {
                this.name = name;
                this.quantity = quantity;
            }

            public String toString() {
                return "Item: " + name + ", Quantity: " + quantity;
            }
        }
    }

    // StaffManager Class
    static class StaffManager {
        static ArrayList<Staff> staffList = new ArrayList<>();

        static void menu() {
            while (true) {
                System.out.println("\n* * * Staff Management * * *");
                System.out.println("1. Add Staff");
                System.out.println("2. View Staff");
                System.out.println("3. Back to Main Menu");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addStaff();
                        break;
                    case 2:
                        viewStaff();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }

        static void addStaff() {
            System.out.print("Enter staff name: ");
            String name = sc.nextLine();
            System.out.print("Enter role: ");
            String role = sc.nextLine();
            staffList.add(new Staff(name, role));
            System.out.println("Staff added successfully.");
        }

        static void viewStaff() {
            if (staffList.isEmpty()) {
                System.out.println("No staff registered.");
                return;
            }
            System.out.println("\n* * * Staff List * * *");
            for (int i = 0; i < staffList.size(); i++) {
                System.out.println((i + 1) + ". " + staffList.get(i));
            }
        }

        static class Staff {
            String name;
            String role;

            Staff(String name, String role) {
                this.name = name;
                this.role = role;
            }

            public String toString() {
                return "Name: " + name + ", Role: " + role;
            }
        }
    }
}
