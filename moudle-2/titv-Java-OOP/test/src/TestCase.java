package management;

import entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CartService {

    // Sử dụng HashMap để lưu sản phẩm và số lượng
    public static void addProductToCart(Map<Product, Integer> cart,
                                        ArrayList<Shirts> shirts,
                                        ArrayList<Pants> pants,
                                        ArrayList<Shoes> shoes,
                                        ArrayList<SportsEquipment> sportsEquipments,
                                        Scanner scanner)
    {
        System.out.print("Enter product ID to add to cart: ");
        String productId = scanner.nextLine().trim();

        // Tìm sản phẩm theo ID
        Product product = ProductManagement.findExistingProduct(productId, shirts, pants, shoes, sportsEquipments);

        if (product != null) {
            try {
                System.out.print("Enter quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine().trim());

                if (quantity <= 0) {
                    throw new IllegalArgumentException("Quantity must be greater than 0.");
                }

                if (quantity > product.getStock()) {
                    throw new IllegalArgumentException("Not enough stock. Available: " + product.getStock());
                }

                // Thêm sản phẩm và cập nhật số lượng
                cart.put(product, cart.getOrDefault(product, 0) + quantity);
                System.out.println(quantity + " " + product.getName() + "(s) added to cart.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity format. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    // Hiển thị giỏ hàng với số lượng từng sản phẩm
    public static void showCart(Map<Product, Integer> cart) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            double cartTotal = 0;

            for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                double totalForProduct = product.getPrice() * quantity;
                cartTotal += totalForProduct;

                System.out.printf("Products: %s - Price: %s - Amount: %d; Total: %s%n",
                        product.getName(),
                        CurrencyFormatter.formatToVND(product.getPrice()),
                        quantity,
                        CurrencyFormatter.formatToVND(totalForProduct));
            }

            System.out.println("Cart total: " + CurrencyFormatter.formatToVND(cartTotal));
        }
    }

    // Thực hiện thanh toán
    public static void checkout(Map<Product, Integer> cart, ArrayList<Shirts> shirts, ArrayList<Pants> pants,
                                ArrayList<Shoes> shoes, ArrayList<SportsEquipment> sportsEquipments,
                                Customer customer, Scanner scanner)
    {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Please add products to your cart before checking out.");
            return;
        }

        System.out.println("===== Checkout =====");
        double cartTotal = 0;

        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double totalForProduct = product.getPrice() * quantity;
            cartTotal += totalForProduct;

            System.out.printf("Products: %s - Price: %s - Amount: %d; Total: %s%n",
                    product.getName(),
                    CurrencyFormatter.formatToVND(product.getPrice()),
                    quantity,
                    CurrencyFormatter.formatToVND(totalForProduct));
        }

        System.out.println("Cart total: " + CurrencyFormatter.formatToVND(cartTotal));

        System.out.print("Proceed to checkout? (yes/no): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            // Cập nhật tồn kho sản phẩm
            for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
                Product cartProduct = entry.getKey();
                int quantity = entry.getValue();
                Product stockProduct = ProductManagement.findExistingProduct(cartProduct.getId(), shirts, pants, shoes, sportsEquipments);
                if (stockProduct != null) {
                    stockProduct.setStock(stockProduct.getStock() - quantity);
                }
            }

            // Lưu lịch sử mua hàng
            PurchaseHistoryService.addPurchaseToHistory(customer, new ArrayList<>(cart.keySet()), cartTotal);
            System.out.println("Checkout complete. Thank you for your purchase!");
            cart.clear(); // Xóa giỏ hàng sau khi thanh toán
            FileService.writeProductsToCSV(shirts, pants, shoes, sportsEquipments); // Cập nhật vào file CSV
        } else {
            System.out.println("Checkout canceled.");
        }
    }
}
