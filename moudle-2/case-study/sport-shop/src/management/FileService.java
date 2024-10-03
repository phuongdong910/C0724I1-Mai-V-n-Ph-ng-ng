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
    private  static final String CUSTOMER_CSV_FILE_PATH = "customers.csv";

    public static void readProductsFromCSV (ArrayList<Shirts> shirts, ArrayList<Pants> pants, ArrayList<Shoes> shoes, ArrayList<SportsEquipment> sportsEquipments) {
        shirts.clear();
        pants.clear();
        shoes.clear();
        sportsEquipments.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))){
            String line;
            while((line = br.readLine()) !=null){
                String [] values = line.split(",");
                if
            }
        }
    }


}
