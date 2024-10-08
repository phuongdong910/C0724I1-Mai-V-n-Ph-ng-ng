package factory;

import entities.Shoes;
import entities.Product;

import java.util.Scanner;

public class ShoesFactory extends ProductFactory {
    @Override
    public Product createProduct(Scanner input) {
        System.out.println("Add new Shoes");
        return new Shoes.Builder()
                .setName(promptForInput(input, "Enter name:"))
                .setBrand(promptForInput(input, "Enter brand:"))
                .setId(promptForInput(input, "Enter ID:"))
                .setColor(promptForInput(input, "Enter color:"))
                .setPrice(Integer.parseInt(promptForInput(input, "Enter price:")))
                .setStock(Integer.parseInt(promptForInput(input, "Enter stock:")))
                .setStatus(promptForInput(input, "Enter status:"))
                .setSize(Integer.parseInt(promptForInput(input, "Enter size:")))
                .setStyle(promptForInput(input, "Enter shoe style:"))
                .setSoleMaterial(promptForInput(input, "Enter sole material:"))
                .build();
    }
}