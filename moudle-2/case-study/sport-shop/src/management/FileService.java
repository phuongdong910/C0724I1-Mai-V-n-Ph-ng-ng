package management;
import entities.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.*;
import java.util.*;

public class FileService {
    private  static final String CSV_FILE_PATH = "product.csv";
    private  static final String CUSTOMERS_CSV_FILE_PATH = "customers.csv";

    public static void readProductsFromCSV (ArrayList<Shirts> shirts, ArrayList<Pants> pants, ArrayList<Shoes> shoes, ArrayList<SportsEquipment> sportsEquipments) {
        shirts.clear();
        pants.clear();
        shoes.clear();
        sportsEquipments.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))){
            String line;
            while((line = br.readLine()) !=null){
                String [] values = line.split(",");
                if(values.length <8 ) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }
                String type = values[0];
                switch (type) {
                    case "Shirts":
                        shirts.add(new Shirts.Builder()
                                .setName(values[1])
                                .setBrand(values[2])
                                .setId(values[3])
                                .setColor(values[4])
                                .setPrice(Integer.parseInt(values[5]))
                                .setStock(Integer.parseInt(values[6]))
                                .setSize(values[7])
                                .setFabric(values[8])
                                .setType(values[9])
                                .build());
                        break;
                    case "Pants":
                        pants.add(new Pants.Builder()
                                .setName(values[1])
                                .setBrand(values[2])
                                .setId(values[3])
                                .setColor(values[4])
                                .setPrice(Integer.parseInt(values[5]))
                                .setStock(Integer.parseInt(values[6]))
                                .setSize(values[7])
                                .setFabric(values[8])
                                .setType(values[9])
                                .build());
                        break;
                    case "Shoes":
                        shoes.add(new Shoes.Builder()
                                .setName(values[1])
                                .setBrand(values[2])
                                .setId(values[3])
                                .setColor(values[4])
                                .setPrice(Integer.parseInt(values[5]))
                                .setStock(Integer.parseInt(values[6]))
                                .setStatus(values[7])
                                .setSize(Integer.parseInt(values[8]))
                                .setStyle(values[9])
                                .setSoleMaterial(values[10])
                                .build());
                        break;
                    case "SportsEquipment":
                        sportsEquipments.add(new SportsEquipment.Builder()
                                .setName(values[1])
                                .setBrand(values[2])
                                .setId(values[3])
                                .setColor(values[4])
                                .setPrice(Integer.parseInt(values[5]))
                                .setStock(Integer.parseInt(values[6]))
                                .setStatus(values[7])
                                .setEquipmentType(values[8])
                                .setMaterial(values[9])
                                .setSize(values[10])
                                .setPurpose(values[11])
                                .setWeight(Double.parseDouble(values[12]))
                                .build());
                        break;
                    default:
                        System.out.println("Unknown product type: " + type);

                }
            }
        } catch (IOException e) {
            System.out.println("No existing products data found. Starting with an empty product list.");
        }catch (NumberFormatException e) {
            System.out.println("Error parsing numeric value: " + e.getMessage());
        }
    }

    public static void writeProductsToCSV (ArrayList<Shirts> shirts, ArrayList<Pants> pants, ArrayList<Shoes> shoes, ArrayList<SportsEquipment> sportsEquipments) {
        try (BufferedWriter bw= new BufferedWriter(new FileWriter(CSV_FILE_PATH))){
            for (Shirts shirt : shirts) {
                bw.write("Shirts, " + shirt.toCSV());
                bw.newLine();
            }
            for (Pants pant : pants) {
                bw.write("Pants, " + pant.toCSV() );
                bw.newLine();
            }
            for (Shoes shoe : shoes) {
                bw.write("Shoes, " + shoe.toCSV() );
                bw.newLine();
            }
            for (SportsEquipment sportsEquipment : sportsEquipments) {
                bw.write("SportsEquipments, " + sportsEquipment.toCSV());
                bw.newLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readCustomersFromCSV(ArrayList<Customer> customers) {
        customers.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMERS_CSV_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                customers.add(new Customer(values[0], values[1]));
            }
        } catch (IOException e) {
            System.out.println("No existing customers data found. Starting with an empty customer list.");
        }
    }

    public static void writeCustomersToCSV(ArrayList<Customer> customers) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CUSTOMERS_CSV_FILE_PATH))) {
            for (Customer customer : customers) {
                bw.write(customer.getUsername() + "," + customer.getPassword());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
