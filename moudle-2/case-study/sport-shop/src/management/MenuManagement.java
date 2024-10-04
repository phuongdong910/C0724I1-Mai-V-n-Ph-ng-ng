package management;

import entities.*;
import view.MenuUI;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManagement {
    private MenuUI menuUI;

    public MenuManagement(ArrayList<Customer> customers, ArrayList<Shirts> shirts, ArrayList<Pants> pants, ArrayList<Shoes> shoes, ArrayList<SportsEquipment> sportsEquipments) {
        Scanner input = new Scanner(System.in);
        this.menuUI = new MenuUI(input, customers, shirts, pants, shoes, sportsEquipments);
    }

    public void mainMenu() {
        menuUI.mainMenu();
    }
}
