package factory;

import entities.Shirts;
import entities.Product;

import java.util.Scanner;

public class ShirtsFactory extends ProductFactory {
    @Override
    public Product createProduct(Scanner input) {
        System.out.println("Add new Shirt");
        return new Shirts.Builder()
                .setName(promptForInput(input, "Enter name:"))
                .setBrand(promptForInput(input, "Enter brand:"))
                .setId(promptForInput(input, "Enter ID:"))
                .setColor(promptForInput(input, "Enter color:"))
                .setPrice(Integer.parseInt(promptForInput(input, "Enter price:")))
                .setStock(Integer.parseInt(promptForInput(input, "Enter stock:")))
                .setSize(promptForInput(input, "Enter size:"))
                .setFabric(promptForInput(input, "Enter fabric:"))
                .setSize(promptForInput(input, "Enter size:"))
                .setType(promptForInput(input, "Enter type:"))
                .build();
    }
}
