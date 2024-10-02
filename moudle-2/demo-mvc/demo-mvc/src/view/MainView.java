package view;

import common.ExceptionHandler;
import common.ExistsHandler;
import controller.ProductController;
import model.Product;

import java.util.List;
import java.util.Scanner;

public class MainView {
    private final ProductController productController = new ProductController();
    private final Scanner scanner = new Scanner(System.in);

    public void renderView() {
        System.out.println("PRODUCT MANAGEMENT");
        this.mainMenu();
    }

    private void mainMenu() {
        while (true) {
            System.out.println(
                    "----------------------------" + " \n" +
                    "Main menu" + "\n" +
                    "1. Product" + "\n" +
                    "0. Exit");
            System.out.print("Choice: ");
            int choice = ExceptionHandler.checkParseInteger();
            switch (choice) {
                case 1:
                    renderProductManagement();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Choice again!");
                    break;
            }
        }
    }

    private void renderProductManagement() {
        while (true) {
            System.out.println(
                    "----------------------------" + " \n" +
                    "Product Management" + "\n" +
                    "1. Add new product" + "\n" +
                    "2. Display product" + "\n" +
                    "0. Return main menu");
            System.out.print("Choice: ");
            int choice = ExceptionHandler.checkParseInteger();
            switch (choice) {
                case 1:
                    Product product = insertProduct();
                    this.productController.addNewProduct(product);
                    break;
                case 2:
                    List<Product> productList = this.productController.findAll();
                    this.displayProduct(productList);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Choice again!");
                    break;
            }
        }
    }

    private Product insertProduct() {
        List<Product> productList = this.productController.findAll();
        System.out.println("----------------------------");
        System.out.print("Nhập id: ");
        int id = ExistsHandler.checkExistsId(productList);
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        return new Product(id, name);
    }

    private void displayProduct(List<Product> productList) {
        for (Product product: productList) {
            System.out.println(product);
        }
    }
}
