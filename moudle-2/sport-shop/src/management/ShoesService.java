package management;

import entities.Shoes;
import factory.ShoesFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoesService extends ProductFieldEditor {
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
            System.out.println("7. Edit Stock");
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
