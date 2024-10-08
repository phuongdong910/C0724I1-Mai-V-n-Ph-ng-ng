package management;

import entities.*;

import java.util.ArrayList;

public class DataManagement {
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Shirts> shirts = new ArrayList<>();
    private static ArrayList<Pants> pants = new ArrayList<>();
    private static ArrayList<Shoes> shoes = new ArrayList<>();
    private static ArrayList<SportsEquipment> sportsEquipments = new ArrayList<>();

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static ArrayList<Shirts> getShirts() {
        return shirts;
    }

    public static ArrayList<Pants> getPants() {
        return pants;
    }

    public static ArrayList<Shoes> getShoes() {
        return shoes;
    }

    public static ArrayList<SportsEquipment> getSportsEquipments() {
        return sportsEquipments;
    }
}
