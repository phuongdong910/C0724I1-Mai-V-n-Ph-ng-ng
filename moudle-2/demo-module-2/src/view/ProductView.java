package view;

import controller.ProductController;
import model.Product;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ProductView {
    private Scanner scanner = new Scanner(System.in);
    private ProductController productController = new ProductController();

    public void renderView() {
        renderMainMenu();
    }

    private void renderMainMenu(){
        while (true) {
            System.out.println("MENU");
            System.out.println("1. Product");
            System.out.println("2. Customer");
            System.out.println("3. Employee");
            System.out.println("4. Contract");
            System.out.println("0. Exist");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    this.renderProductMenu();
                    break;
                case 2:
                    System.out.println("Customer");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!!");
            }
        }
    }

    private void renderProductMenu() {
        while (true) {
            System.out.println("PRODUCT MANAGEMENT");
            System.out.println("1. Display");
            System.out.println("2. Add New Product");
            System.out.println("3. Edit Product");
            System.out.println("4. Delete Product");
            System.out.println("0. Return main menu");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayProduct();
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    editProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!!");
            }
        }
    }

    private void editProduct() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = this.productController.findById(id);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        Product productEdit = new Product(product.getId(), name, price);
        this.productController.update(productEdit);
    }

    private void deleteProduct() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = this.productController.findById(id);
        if (Objects.isNull(product)) {
            System.out.println("Product not found!!");
        } else {
            System.out.println("Do you want to delete product " + product.getName() + "?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Choice: ");
            int deleteChoice = Integer.parseInt(scanner.nextLine());
            if (deleteChoice == 1) {
                this.productController.delete(product);
                System.out.println("Delete success!!");
            } else {
                System.out.println("Close!!");
            }
        }
    }

    private void addNewProduct() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(id, name, price);
        this.productController.save(product);
    }

    private void displayProduct() {
        System.out.println("Display products");
        List<Product> products = this.productController.findAll();
        for (Product product: products) {
            System.out.println(product);
        }
    }
}
