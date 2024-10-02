package factory;

import entities.Pants;
import entities.Product;

import java.util.Scanner;

public class PantsFactory extends ProductFactory {
    @Override
    public Product createProduct(Scanner input) {
        System.out.println("Add new Shirt");
        return new Pants.Builder()
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
