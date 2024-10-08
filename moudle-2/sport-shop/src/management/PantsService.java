package management;

import entities.Pants;
import factory.PantsFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class PantsService extends ProductFieldEditor {

    // Thêm một sản phẩm Pants mới vào danh sách
    public static void addPants(ArrayList<Pants> pantsList, Scanner input) {
        PantsFactory factory = new PantsFactory();
        Pants newPants = (Pants) factory.createProduct(input); // Tạo sản phẩm mới từ factory
        pantsList.add(newPants);  // Thêm sản phẩm vào danh sách
        System.out.println("Pants added successfully.");
    }

    // Chỉnh sửa thông tin sản phẩm Pants
    public static boolean editPants(Pants pants, Scanner input) {
        boolean update = false;
        while (true) {
            System.out.println("\nEdit Pants Menu: ");
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
            System.out.println("0. Finish Editing Pants");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        pants.setName(editStringField("name", pants.getName(), input));
                        update = true;
                        break;
                    case 2:
                        pants.setBrand(editStringField("brand", pants.getBrand(), input));
                        update = true;
                        break;
                    case 3:
                        pants.setId(editStringField("id", pants.getId(), input));
                        update = true;
                        break;
                    case 4:
                        pants.setColor(editStringField("color", pants.getColor(), input));
                        update = true;
                        break;
                    case 5:
                        pants.setPrice(editIntegerField("price", pants.getPrice(), input));
                        update = true;
                        break;
                    case 6:
                        pants.setStock(editIntegerField("stock", pants.getStock(), input));
                        update = true;
                        break;
                    case 7:
                        pants.setStatus(editStringField("status", pants.getStatus(), input));
                        update = true;
                        break;
                    case 8:
                        pants.setSize(editStringField("size", pants.getSize(), input));
                        update = true;
                        break;
                    case 9:
                        pants.setFabric(editStringField("fabric", pants.getFabric(), input));
                        update = true;
                        break;
                    case 10:
                        pants.setType(editStringField("type", pants.getType(), input));
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
