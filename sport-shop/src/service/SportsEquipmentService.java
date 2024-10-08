package service;

import entities.Shoes;
import entities.SportsEquipment;
import factory.ShoesFactory;
import factory.SportsEquipmentFactory;
import management.ProductFieldEditor;

import java.util.ArrayList;
import java.util.Scanner;

public class SportsEquipmentService extends ProductFieldEditor {

    // Thêm mới một sản phẩm Sports Equipment
    public static void addSportsEquipment(ArrayList<SportsEquipment> equipmentList, Scanner input) {
        SportsEquipmentFactory factory = new SportsEquipmentFactory();
        SportsEquipment newEquipment = (SportsEquipment) factory.createProduct(input); // Tạo sản phẩm mới từ factory
        equipmentList.add(newEquipment);  // Thêm sản phẩm vào danh sách
        System.out.println("Sports Equipment added successfully.");
    }

    // Chỉnh sửa thông tin sản phẩm Sports Equipment
    public static boolean editSportsEquipment(SportsEquipment equipment, Scanner input) {
        boolean update = false;
        while (true) {
            System.out.println("\nEdit Sports Equipment Menu:");
            System.out.println("1. Edit Name");
            System.out.println("2. Edit Brand");
            System.out.println("3. Edit ID");
            System.out.println("4. Edit Color");
            System.out.println("5. Edit Price");
            System.out.println("6. Edit Stock");
            System.out.println("7. Edit Status");
            System.out.println("8. Edit Equipment Type");
            System.out.println("9. Edit Material");
            System.out.println("10. Edit Size");
            System.out.println("11. Edit Purpose");
            System.out.println("12. Edit Weight");
            System.out.println("0. Finish Editing Equipment");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        equipment.setName(editStringField("name", equipment.getName(), input));
                        update = true;
                        break;
                    case 2:
                        equipment.setBrand(editStringField("brand", equipment.getBrand(), input));
                        update = true;
                        break;
                    case 3:
                        equipment.setId(editStringField("id", equipment.getId(), input));
                        update = true;
                        break;
                    case 4:
                        equipment.setColor(editStringField("color", equipment.getColor(), input));
                        update = true;
                        break;
                    case 5:
                        equipment.setPrice(editIntegerField("price", equipment.getPrice(), input));
                        update = true;
                        break;
                    case 6:
                        equipment.setStock(editIntegerField("stock", equipment.getStock(), input));
                        update = true;
                        break;
                    case 7:
                        equipment.setStatus(editStringField("status", equipment.getStatus(), input));
                        update = true;
                        break;
                    case 8:
                        equipment.setEquipmentType(editStringField("equipment type", equipment.getEquipmentType(), input));
                        update = true;
                        break;
                    case 9:
                        equipment.setMaterial(editStringField("material", equipment.getMaterial(), input));
                        update = true;
                        break;
                    case 10:
                        equipment.setSize(editStringField("size", equipment.getSize(), input));
                        update = true;
                        break;
                    case 11:
                        equipment.setPurpose(editStringField("purpose", equipment.getPurpose(), input));
                        update = true;
                        break;
                    case 12:
                        equipment.setWeight(editDoubleField("weight", equipment.getWeight(), input));
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

    public static class ShoesService extends ProductFieldEditor {
        public static void addShoes(ArrayList<Shoes> shoes, Scanner input) {
            ShoesFactory factory = new ShoesFactory();
            Shoes newShoes = (Shoes) factory.createProduct(input);
            shoes.add(newShoes);
            System.out.println("Shoes added successfully.");
        }

        public static boolean editShoes(Shoes shoes, Scanner input) {
            boolean update = false;
            while (true){
                System.out.println("\nEdit Shoes Menu: ");
                System.out.println("1. Edit Name");
                System.out.println("2.Edit Brand");
                System.out.println("3.Edit ID");
                System.out.println("4.Edit Color");
                System.out.println("5. Edit Price");
                System.out.println("6. Edit Stock");
                System.out.println("7. Edit Status");
                System.out.println("8. Edit Size");
                System.out.println("9. Edit Style");
                System.out.println("10. Edit Sole Material");
                System.out.println("0. Finish Editing Shoes");
                System.out.print("Enter your choice: ");

                try {
                    int choice = Integer.parseInt(input.nextLine());
                    switch (choice) {
                        case 1:
                            shoes.setName(editStringField("name", shoes.getName(), input));
                            update = true;
                            break;
                        case 2:
                            shoes.setBrand((editStringField("brand", shoes.getBrand(), input)));
                            update = true;
                            break;
                        case 3:
                            shoes.setId(editStringField("id", shoes.getId(), input));
                            update = true;
                            break;
                        case 4:
                            shoes.setColor(editStringField("color", shoes.getColor(), input));
                            update = true;
                            break;
                        case 5:
                            shoes.setPrice(editIntegerField("price", shoes.getPrice(), input));
                            update = true;
                            break;
                        case 6:
                            shoes.setStock(editIntegerField("stock", shoes.getStock(), input));
                            update =true;
                            break;
                        case  7:
                            shoes.setStatus(editStringField("status", shoes.getStatus(), input));
                            update = true;
                            break;
                        case 8:
                            shoes.setSize(editIntegerField("size", shoes.getSize(), input));
                            update =true;
                            break;
                        case 9:
                            shoes.setStyle((editStringField("style", shoes.getStyle(), input)));
                            update = true;
                            break;
                        case 10:
                            shoes.setSoleMaterial((editStringField("material", shoes.getSoleMaterial(), input)));
                            update = true;
                            break;
                        case 0:
                            return  update;
                        default:
                        System.out.println("Invalid choice. Please try again.");

                    }
                }catch (NumberFormatException e){
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
        }
    }
}
