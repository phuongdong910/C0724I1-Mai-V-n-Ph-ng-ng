package management;

import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import service.FileService;
import service.PantsService;
import service.ShirtsService;
import service.SportsEquipmentService;


public class ProductManagement {
    public static void showAllProducts(ArrayList<Shirts> shirts, ArrayList<Pants> pants, ArrayList<Shoes> shoes, ArrayList<SportsEquipment> sportsEquipments) {
        System.out.println("========All Products ========");

        showShirts(shirts);
        showPants(pants);
        showShoes(shoes);
        showSportsEquipment(sportsEquipments);
    }

    private static void showShoes(List<Shoes> shoesList) {
        System.out.println("\nShoes:");
        if (shoesList.isEmpty()) {
            System.out.println("No shoes available.");
        } else {
            String format = "| %-6s | %-30s | %-15s | %-15s | %-15s | %-8s | %-15s | %-10s | %-15s | %-15s |";
            System.out.println(String.format(format, "ID", "Name", "Brand", "Color", "Price", "Stock", "Status", "Size", "Style", "Sole Material"));
            System.out.println("-".repeat(175));

            for (Shoes shoes : shoesList) {
                System.out.println(String.format(format,
                        shoes.getId(),
                        truncate(shoes.getName(), 30),
                        truncate(shoes.getBrand(), 15),
                        truncate(shoes.getColor(), 15),
                        CurrencyFormatter.formatToVND(shoes.getPrice()),
                        shoes.getStock(),
                        shoes.getStatus(),
                        shoes.getSize(),
                        truncate(shoes.getStyle(), 10),
                        truncate(shoes.getSoleMaterial(), 15)
                ));
            }
            System.out.println("-".repeat(175));
        }
    }

    private static void showPants(List<Pants> pantsList) {
        System.out.println("\nPants List:");
        if (pantsList.isEmpty()) {
            System.out.println("No pants available.");
        } else {
            String format =  "| %-6s | %-30s | %-15s | %-15s | %-15s | %-8s | %-15s | %-15s | %-20s | %-20s |";
            // In tiêu đề bảng
            System.out.println(String.format(format, "ID", "Name", "Brand", "Color", "Price", "Stock", "Status", "Size", "Fabric", "Type"));
            System.out.println("-".repeat(190));

            for (Pants pants : pantsList) {
                System.out.println(String.format(format,
                        pants.getId(),
                        truncate(pants.getName(), 30),
                        truncate(pants.getBrand(), 15),
                        truncate(pants.getColor(), 15),
                        CurrencyFormatter.formatToVND(pants.getPrice()),
                        pants.getStock(),
                        pants.getStatus(),
                        pants.getSize(),
                        truncate(pants.getFabric(), 20),
                        pants.getType()
                ));
            }
            System.out.println("-".repeat(190));
        }
    }

    private static void showShirts(List<Shirts> shirtsList) {
        System.out.println("\nShirts List:");
        if (shirtsList.isEmpty()) {
            System.out.println("No shirts available.");
        } else {
            String format = "| %-6s | %-30s | %-15s | %-15s | %-15s | %-8s | %-15s | %-15s | %-20s | %-20s |";
            // In tiêu đề bảng
            System.out.println(String.format(format, "ID", "Name", "Brand", "Color", "Price", "Stock", "Status", "Size", "Fabric", "Type"));
            System.out.println("-".repeat(190));

            for (Shirts shirt : shirtsList) {
                System.out.println(String.format(format,
                        shirt.getId(),
                        truncate(shirt.getName(), 30),
                        truncate(shirt.getBrand(), 15),
                        truncate(shirt.getColor(), 15),
                        CurrencyFormatter.formatToVND(shirt.getPrice()),
                        shirt.getStock(),
                        shirt.getStatus(),
                        shirt.getSize(),
                        truncate(shirt.getFabric(), 15),
                        shirt.getType()
                ));
            }
            System.out.println("-".repeat(190));
        }
    }

    private static void  showSportsEquipment(List<SportsEquipment> equipmentList) {
        System.out.println("\nSports Equipment List:");
        if (equipmentList.isEmpty()) {
            System.out.println("No sports equipment available.");
        } else {
            String format = "| %-6s | %-30s | %-15s | %-15s | %-15s | %-8s | %-15s | %-15s | %-15s | %-15s | %-20s | %-10s |";
            // In tiêu đề bảng
            System.out.println(String.format(format, "ID", "Name", "Brand", "Color", "Price", "Stock", "Status", "Equipment Type", "Size", "Material", "Purpose", "Weight"));
            System.out.println("-".repeat(212));

            for (SportsEquipment equipment : equipmentList) {
                System.out.println(String.format(format,
                        equipment.getId(),
                        truncate(equipment.getName(), 30),
                        truncate(equipment.getBrand(), 15),
                        truncate(equipment.getColor(), 15),
                        CurrencyFormatter.formatToVND(equipment.getPrice()),
                        equipment.getStock(),
                        equipment.getStatus(),
                        truncate(equipment.getEquipmentType(), 15),
                        truncate(equipment.getSize(), 15),
                        truncate(equipment.getMaterial(), 15),
                        equipment.getPurpose(),
                        equipment.getWeight()
                ));
            }
            System.out.println("-".repeat(212));
        }
    }


    private static String truncate(String str, int length) {
        return str.length() > length ? str.substring(0, length - 3) + "..." : str;
    }

    public static void editProduct(Scanner input, ArrayList<Shirts> shirts, ArrayList<Pants> pants, ArrayList<Shoes> shoes, ArrayList<SportsEquipment> sportsEquipments) {
        System.out.print("Enter the ID of the product you want to edit: ");
        String productId = input.nextLine().trim();

        Product product = findExistingProduct(productId, shirts, pants, shoes, sportsEquipments);

        if (product != null) {
            boolean updated = false;
            if (product instanceof Shirts) {
                updated = ShirtsService.editShirts((Shirts) product, input);
            } else if (product instanceof Pants) {
                updated = PantsService.editPants((Pants) product, input);
            } else if (product instanceof Shoes) {
                updated = SportsEquipmentService.ShoesService.editShoes((Shoes) product, input);
            } else if (product instanceof SportsEquipment) {
                updated = SportsEquipmentService.editSportsEquipment((SportsEquipment) product, input);
            }

            if (updated) {
                System.out.println("Product has been updated successfully.");
                FileService.writeProductsToCSV(shirts, pants, shoes, sportsEquipments);
            } else {
                System.out.println("No changes were made to the product..");
            }
        } else {
            System.out.println("No product found with entered ID.");
        }
    }

    public static void deleteProduct(Scanner input, ArrayList<Shirts> shirts, ArrayList<Pants> pants, ArrayList<Shoes> shoes, ArrayList<SportsEquipment> sportsEquipments) {
        System.out.print("Enter the ID of the product you want to delete: ");
        String productId = input.nextLine();

        Product product = findExistingProduct(productId, shirts, pants, shoes, sportsEquipments);

        if (product != null) {
            if (product instanceof Shirts) {
                shirts.remove(product);
            } else if (product instanceof Pants) {
                pants.remove(product);
            } else if (product instanceof Shoes) {
                shoes.remove(product);
            } else if (product instanceof SportsEquipment) {
                sportsEquipments.remove(product);
            }
            System.out.println("Product has been deleted successfully.");
            FileService.writeProductsToCSV(shirts, pants, shoes, sportsEquipments);
        } else {
            System.out.println("No product found with entered ID.");
        }
    }

    public static Product findExistingProduct(String productId, ArrayList<Shirts> shirts, ArrayList<Pants> pants, ArrayList<Shoes> shoes, ArrayList<SportsEquipment> sportsEquipments) {
        for (Shirts shirt : shirts) {
            if (shirt.getId().equalsIgnoreCase(productId)) {
                return shirt;
            }
        }
        for (Pants pant : pants) {
            if (pant.getId().equalsIgnoreCase(productId)) {
                return pant;
            }
        }
        for (Shoes shoe : shoes) {
            if (shoe.getId().equalsIgnoreCase(productId)) {
                return shoe;
            }
        }
        for (SportsEquipment equipment : sportsEquipments) {
            if (equipment.getId().equalsIgnoreCase(productId)) {
                return equipment;
            }
        }
        return null;
    }

    public static void searchProductByName(Scanner input, ArrayList<Shirts> shirts, ArrayList<Pants> pants, ArrayList<Shoes> shoes, ArrayList<SportsEquipment> sportsEquipments) {
        System.out.print("Enter the name of the product you want to search: ");
        String productName = input.nextLine().trim().toLowerCase();

        List<Product> matchingProducts = new ArrayList<>();

        for (Shirts shirt : shirts) {
            if (shirt.getName().toLowerCase().contains(productName)) {
                matchingProducts.add(shirt);
            }
        }

        for (Pants pant : pants) {
            if (pant.getName().toLowerCase().contains(productName)) {
                matchingProducts.add(pant);
            }
        }

        for (Shoes shoe : shoes) {
            if (shoe.getName().toLowerCase().contains(productName)) {
                matchingProducts.add(shoe);
            }
        }

        for (SportsEquipment equipment : sportsEquipments) {
            if (equipment.getName().toLowerCase().contains(productName)) {
                matchingProducts.add(equipment);
            }
        }

        if (matchingProducts.isEmpty()) {
            System.out.println("No products found containing this name '" + productName + "'.");
        } else {
            System.out.println("Search results for products containing '" + productName + "':");
            for (Product product : matchingProducts) {
                System.out.println(product);
            }
        }
    }


}
