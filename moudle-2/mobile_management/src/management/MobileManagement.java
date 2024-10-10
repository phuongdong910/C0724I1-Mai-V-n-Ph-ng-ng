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
        String id = scanner.nextLine().trim();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        // Kiểm tra giá bán
        System.out.print("Enter Price: ");
        double price;
        while (true) {
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price <= 0) {
                    System.out.println("Price must be a positive number. Please enter again: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for price: ");
            }
        }

        // Kiểm tra số lượng
        System.out.print("Enter Quantity: ");
        int quantity;
        while (true) {
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity <= 0) {
                    System.out.println("Quantity must be a positive number. Please enter again: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for quantity: ");
            }
        }

        System.out.print("Enter Manufacturer: ");
        String manufacturer = scanner.nextLine().trim();

        if (choice == 1) {
            System.out.print("Enter Warranty Period (months): ");
            int warrantyPeriod;
            while (true) {
                try {
                    warrantyPeriod = Integer.parseInt(scanner.nextLine());
                    if (warrantyPeriod <= 0) {
                        System.out.println("Warranty period must be a positive number. Please enter again: ");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number for warranty period: ");
                }
            }

            System.out.print("Enter Warranty Scope (domestic/international): ");
            String warrantyScope = scanner.nextLine().trim();

            OfficialMobile officialMobile = new OfficialMobile(id, name, price, quantity, manufacturer, warrantyPeriod, warrantyScope);
            mobiles.add(officialMobile);
        } else if (choice == 2) {
            System.out.print("Enter Import Country: ");
            String importCountry = scanner.nextLine().trim();

            // Kiểm tra quốc gia xách tay không được là "Viet Nam"
            while (importCountry.equalsIgnoreCase("Viet Nam")) {
                System.out.println("Import country cannot be 'Viet Nam'. Please enter again: ");
                importCountry = scanner.nextLine().trim();
            }

            // Cập nhật trạng thái sửa chữa
            System.out.print("Enter Status (repaired/not repaired): ");
            String status = scanner.nextLine().trim();

            // Kiểm tra trạng thái
            while (!status.equalsIgnoreCase("repaired") && !status.equalsIgnoreCase("not repaired")) {
                System.out.println("Status must be 'repaired' or 'not repaired'. Please enter again: ");
                status = scanner.nextLine().trim();
            }

            ImportedMobile importedMobile = new ImportedMobile(id, name, price, quantity, manufacturer, importCountry, status);
            mobiles.add(importedMobile);
        }

        // Ghi dữ liệu vào file
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
