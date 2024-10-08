package management;

import entities.Shirts;
import factory.ShirtsFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class ShirtsService extends ProductFieldEditor {

    // Thêm sản phẩm áo (Shirts)
    public static void addShirts(ArrayList<Shirts> shirtsList, Scanner input) {
        ShirtsFactory factory = new ShirtsFactory();  // Khởi tạo ShirtsFactory
        Shirts newShirt = (Shirts) factory.createProduct(input);  // Tạo sản phẩm mới từ factory
        shirtsList.add(newShirt);  // Thêm sản phẩm mới vào danh sách
        System.out.println("Shirt added successfully.");
    }

    // Chỉnh sửa thông tin áo (Shirts)
    public static boolean editShirts(Shirts shirt, Scanner input) {
        boolean update = false;
        while (true) {
            System.out.println("\nEdit Shirt Menu: ");
            System.out.println("1. Edit Name");
            System.out.println("2. Edit Brand");
            System.out.println("3. Edit ID");
            System.out.println("4. Edit Color");
            System.out.println("5. Edit Price");
            System.out.println("6. Edit Stock");
            System.out.println("7. Edit Status");
            System.out.println("8. Edit Size");
            System.out.println("9. Edit Fabric");
            System.out.println("10. Edit Type");
            System.out.println("0. Finish Editing Shirt");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(input.nextLine());  // Đọc lựa chọn từ người dùng
                switch (choice) {
                    case 1:
                        shirt.setName(editStringField("name", shirt.getName(), input));
                        update = true;
                        break;
                    case 2:
                        shirt.setBrand(editStringField("brand", shirt.getBrand(), input));
                        update = true;
                        break;
                    case 3:
                        shirt.setId(editStringField("id", shirt.getId(), input));
                        update = true;
                        break;
                    case 4:
                        shirt.setColor(editStringField("color", shirt.getColor(), input));
                        update = true;
                        break;
                    case 5:
                        shirt.setPrice(editIntegerField("price", shirt.getPrice(), input));
                        update = true;
                        break;
                    case 6:
                        shirt.setStock(editIntegerField("stock", shirt.getStock(), input));
                        update = true;
                        break;
                    case 7:
                        shirt.setStatus(editStringField("status", shirt.getStatus(), input));
                        update = true;
                        break;
                    case 8:
                        shirt.setSize(editStringField("size", shirt.getSize(), input));
                        update = true;
                        break;
                    case 9:
                        shirt.setFabric(editStringField("fabric", shirt.getFabric(), input));
                        update = true;
                        break;
                    case 10:
                        shirt.setType(editStringField("type", shirt.getType(), input));
                        update = true;
                        break;
                    case 0:
                        return update;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
