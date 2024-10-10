import entities.NormalPatient;
import entities.VipPatient;
import management.HospitalManagement;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalManagement management = new HospitalManagement();

        while (true) {
            System.out.println("\n--- Hospital Management ---");
            System.out.println("1. Add Normal Patient");
            System.out.println("2. Add VIP Patient");
            System.out.println("3. Remove Patient");
            System.out.println("4. Display All Patients");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    management.addPatient(createNormalPatient(scanner));
                    break;

                case 2:
                    management.addPatient(createVipPatient(scanner));
                    break;

                case 3:
                    System.out.print("Enter Patient ID to remove: ");
                    String id = scanner.nextLine();
                    management.removePatient(id);
                    break;

                case 4:
                    management.displayAllPatients();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static NormalPatient createNormalPatient(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Enter Admission Date (yyyy-mm-dd): ");
        LocalDate admissionDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter Discharge Date (yyyy-mm-dd): ");
        LocalDate dischargeDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter Status: ");
        String status = scanner.nextLine();

        return new NormalPatient(id, name, age, gender, diagnosis, admissionDate, dischargeDate, status);
    }

    private static VipPatient createVipPatient(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Enter Admission Date (yyyy-mm-dd): ");
        LocalDate admissionDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter Discharge Date (yyyy-mm-dd): ");
        LocalDate dischargeDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter Status: ");
        String status = scanner.nextLine();

        return new VipPatient(id, name, age, gender, diagnosis, admissionDate, dischargeDate, status);
    }
}
