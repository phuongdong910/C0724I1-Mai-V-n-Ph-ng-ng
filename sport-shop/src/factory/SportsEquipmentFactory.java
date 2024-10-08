package factory;

import entities.SportsEquipment;
import entities.Product;

import java.util.Scanner;

public class SportsEquipmentFactory extends ProductFactory {
    @Override
    public Product createProduct(Scanner input) {
        System.out.println("Add new Sports Equipment");
        return new SportsEquipment.Builder()
                .setName(promptForInput(input, "Enter name:"))
                .setBrand(promptForInput(input, "Enter brand:"))
                .setId(promptForInput(input, "Enter ID:"))
                .setColor(promptForInput(input, "Enter color:"))
                .setPrice(Integer.parseInt(promptForInput(input, "Enter price:")))
                .setStock(Integer.parseInt(promptForInput(input, "Enter stock:")))
                .setStatus(promptForInput(input, "Enter status:"))
                .setEquipmentType(promptForInput(input, "Enter equipmentType:"))
                .setSize(promptForInput(input, "Enter size:"))
                .setMaterial(promptForInput(input, "Enter material"))
                .setPurpose(promptForInput(input, "Enter purpose:"))
                .setWeight(Double.parseDouble(promptForInput(input, "Enter weight")))
                .build();
    }
}