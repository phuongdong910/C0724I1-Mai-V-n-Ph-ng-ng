package management;

import entities.*;
import service.FileService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MobileManagement {
    private List<Mobile> mobiles;
    private static final String FILE_PATH = "mobiles.csv";

    public MobileManagement() {
        mobiles = new ArrayList<>();
        loadMobilesFromCSV();
    }

    public void loadMobilesFromCSV() {
        mobiles = FileService.readMobilesFromCSV(FILE_PATH);
    }

    public void addMobile(Scanner scanner) {
        System.out.println("Choose Mobile Type:\n1. Official\n2. Imported");
        int choice = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Manufacturer: ");
        String manufacturer = scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter Warranty Period (months): ");
            int warrantyPeriod = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Warranty Scope (domestic/international): ");
            String warrantyScope = scanner.nextLine();
            OfficialMobile officialMobile = new OfficialMobile(id, name, price, quantity, manufacturer, warrantyPeriod, warrantyScope);
            mobiles.add(officialMobile);
        } else if (choice == 2) {
            System.out.print("Enter Import Country: ");
            String importCountry = scanner.nextLine();
            System.out.print("Enter Status (new/used): ");
            String status = scanner.nextLine();
            ImportedMobile importedMobile = new ImportedMobile(id, name, price, quantity, manufacturer, importCountry, status);
            mobiles.add(importedMobile);
        }

        FileService.writeMobilesToCSV(mobiles, FILE_PATH);
        System.out.println("Mobile added successfully.");
    }

    public void deleteMobile(Scanner scanner) {
        System.out.print("Enter ID of the mobile to delete: ");
        String id = scanner.nextLine();

        boolean removed = mobiles.removeIf(mobile -> mobile.getId().equalsIgnoreCase(id));
        if (removed) {
            FileService.writeMobilesToCSV(mobiles, FILE_PATH);
            System.out.println("Mobile deleted successfully.");
        } else {
            System.out.println("Mobile not found.");
        }
    }

    public void viewAllMobiles() {
        System.out.println("======= Mobile List =======");
        for (Mobile mobile : mobiles) {
            System.out.println(mobile);
        }
    }

    public void searchMobile(Scanner scanner) {
        System.out.print("Enter mobile ID or name to search: ");
        String searchTerm = scanner.nextLine();

        boolean found = false; // Biến để kiểm tra xem có tìm thấy điện thoại hay không

        for (Mobile mobile : mobiles) {
            // Sử dụng contains để kiểm tra xem searchTerm có nằm trong ID hoặc Name hay không
            if (mobile.getId().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    mobile.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println(mobile);
                found = true; // Đánh dấu là đã tìm thấy
            }
        }

        if (!found) {
            System.out.println("No mobile found.");
        }
    }

}
