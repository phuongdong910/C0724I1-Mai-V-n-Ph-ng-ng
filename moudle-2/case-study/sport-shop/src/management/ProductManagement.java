package management;

import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import management.ShirtsService;
import  management.PantsService;


public class ProductManagement {
    public static void showAllProducts(ArrayList<Shirts> shirts, ArrayList<Pants> pants, ArrayList<Shoes> shoes, ArrayList<SportsEquipment> sportsEquipments) {
        System.out.println("========All Products ========");

        showShirts(shirts);
        showPants(pants);
        showShoes(shoes);
        showSprotsEquipment(sportsEquipments);
    }

    private static void showShoes(List<Shoes> shoesList) {
        System.out.println("\nShoes:");
        if (shoesList.isEmpty()) {
            System.out.println("No shoes available.");
        } else {
            String format = "| %-6s | %-30s | %-15s | %-15s | %-15s | %-8s | %-10s | %-15s | %-15s |";
            System.out.println(String.format(format, "ID", "Name", "Brand", "Color", "Price", "Stock", "Size", "Style", "Sole Material"));
            System.out.println("-".repeat(160));

            for (Shoes shoes : shoesList) {
                System.out.println(String.format(format,
                        shoes.getId(),
                        truncate(shoes.getName(), 30),
                        truncate(shoes.getBrand(), 15),
                        truncate(shoes.getColor(), 15),
                        CurrencyFormatter.formatToVND(shoes.getPrice()),
                        shoes.getStock(),
                        shoes.getSize(),
                        truncate(shoes.getStyle(), 10),
                        truncate(shoes.getSoleMaterial(), 15)
                ));
            }
            System.out.println("-".repeat(160));
        }
    }

    private static void showPants(List<Pants> pantsList) {
        System.out.println("\nPants List:");
        if (pantsList.isEmpty()) {
            System.out.println("No pants available.");
        } else {
            String format = "| %-6s | %-30s | %-15s | %-15s | %-15s | %-8s | %-10s | %-15s |";
            // In tiêu đề bảng
            System.out.println(String.format(format, "ID", "Name", "Brand", "Color", "Price", "Stock", "Size", "Fabric"));
            System.out.println("-".repeat(120));

            for (Pants pants : pantsList) {
                System.out.println(String.format(format,
                        pants.getId(),
                        truncate(pants.getName(), 30),
                        truncate(pants.getBrand(), 15),
                        truncate(pants.getColor(), 15),
                        CurrencyFormatter.formatToVND(pants.getPrice()),
                        pants.getStock(),
                        pants.getSize(),
                        truncate(pants.getFabric(), 15)
                ));
            }
            System.out.println("-".repeat(120));
        }
    }

    private static void showShirts(List<Shirts> shirtsList) {
        System.out.println("\nShirts List:");
        if (shirtsList.isEmpty()) {
            System.out.println("No shirts available.");
        } else {
            String format = "| %-6s | %-30s | %-15s | %-15s | %-15s | %-8s | %-10s | %-15s |";
            // In tiêu đề bảng
            System.out.println(String.format(format, "ID", "Name", "Brand", "Color", "Price", "Stock", "Size", "Fabric"));
            System.out.println("-".repeat(120));

            for (Shirts shirt : shirtsList) {
                System.out.println(String.format(format,
                        shirt.getId(),
                        truncate(shirt.getName(), 30),
                        truncate(shirt.getBrand(), 15),
                        truncate(shirt.getColor(), 15),
                        CurrencyFormatter.formatToVND(shirt.getPrice()),
                        shirt.getStock(),
                        shirt.getSize(),
                        truncate(shirt.getFabric(), 15)
                ));
            }
            System.out.println("-".repeat(120));
        }
    }

    private static void  showSprotsEquipment(List<SportsEquipment> equipmentList) {
        System.out.println("\nSports Equipment List:");
        if (equipmentList.isEmpty()) {
            System.out.println("No sports equipment available.");
        } else {
            String format = "| %-6s | %-30s | %-15s | %-15s | %-15s | %-8s | %-15s | %-15s | %-10s | %-10s |";
            // In tiêu đề bảng
            System.out.println(String.format(format, "ID", "Name", "Brand", "Color", "Price", "Stock", "Equipment Type", "Material", "Size", "Weight"));
            System.out.println("-".repeat(150));

            for (SportsEquipment equipment : equipmentList) {
                System.out.println(String.format(format,
                        equipment.getId(),
                        truncate(equipment.getName(), 30),
                        truncate(equipment.getBrand(), 15),
                        truncate(equipment.getColor(), 15),
                        CurrencyFormatter.formatToVND(equipment.getPrice()),
                        equipment.getStock(),
                        truncate(equipment.getEquipmentType(), 15),
                        truncate(equipment.getMaterial(), 15),
                        truncate(equipment.getSize(), 10),
                        equipment.getWeight()
                ));
            }
            System.out.println("-".repeat(150));
        }
    }


    private static String truncate(String str, int length) {
        return str.length() > length ? str.substring(0, length - 3) + "..." : str;
    }

    public static void editProduct(Scanner input, ArrayList<Shirts> shirts, ArrayList<Pants> pants, ArrayList<Shoes> shoes, ArrayList<SportsEquipment> sportsEquipments) {
        System.out.print("Nhập ID của sản phẩm bạn muốn chỉnh sửa: ");
        String productId = input.nextLine().trim();

        Product product = findExistingProduct(productId, shirts, pants, shoes, sportsEquipments);

        if (product != null) {
            boolean updated = false;
            if (product instanceof Shirts) {
                updated = ShirtsService.editShirts((Shirts) product, input);
            } else if (product instanceof Pants) {
                updated = PantsService.editPants((Pants) product, input);
            } else if (product instanceof Shoes) {
                updated = ShoesService.editShoes((Shoes) product, input);
            } else if (product instanceof SportsEquipment) {
                updated = SportsEquipmentService.editSportsEquipment((SportsEquipment) product, input);
            }

            if (updated) {
                System.out.println("Sản phẩm đã được cập nhật thành công.");
                FileService.writeProductsToCSV(shirts, pants, shoes, sportsEquipments);
            } else {
                System.out.println("Không có thay đổi nào được thực hiện cho sản phẩm.");
            }
        } else {
            System.out.println("Không tìm thấy sản phẩm với ID đã nhập.");
        }
    }

    public static void deleteProduct(Scanner input, ArrayList<Shirts> shirts, ArrayList<Pants> pants, ArrayList<Shoes> shoes, ArrayList<SportsEquipment> sportsEquipments) {
        System.out.print("Nhập ID của sản phẩm bạn muốn xóa: ");
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
            System.out.println("Sản phẩm đã được xóa thành công.");
            FileService.writeProductsToCSV(shirts, pants, shoes, sportsEquipments);
        } else {
            System.out.println("Không tìm thấy sản phẩm với ID đã nhập.");
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



}
