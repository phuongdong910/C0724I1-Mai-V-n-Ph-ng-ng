import management.MobileManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MobileManagement mobileManagement = new MobileManagement();

        while (true) {
            System.out.println("\n======= Mobile Management Menu =======");
            System.out.println("1. Add Mobile");
            System.out.println("2. Delete Mobile");
            System.out.println("3. View All Mobiles");
            System.out.println("4. Search Mobile");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    mobileManagement.addMobile(scanner);
                    break;
                case 2:
                    mobileManagement.deleteMobile(scanner);
                    break;
                case 3:
                    mobileManagement.viewAllMobiles();
                    break;
                case 4:
                    mobileManagement.searchMobile(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
