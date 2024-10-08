package management;

import service.FileService;

public class ApplicationManager {
    private  static DataManagement dataManagement;
    private  static  MenuManagement menuManagement;

    public static void run() {
        initialize();
        initializeData();
        runMainMenu();
        saveData();
    }
    private static void initialize() {
        dataManagement = new DataManagement();
        menuManagement = new MenuManagement(
                dataManagement.getCustomers(),
                dataManagement.getShirts(),
                dataManagement.getPants(),
                dataManagement.getShoes(),
                dataManagement.getSportsEquipments()
        );
    }

    private static void initializeData() {
        FileService.readProductsFromCSV(
                dataManagement.getShirts(),
                dataManagement.getPants(),
                dataManagement.getShoes(),
                dataManagement.getSportsEquipments()
        );
        FileService.readCustomersFromCSV(dataManagement.getCustomers());
    }

    private static void runMainMenu() {
        menuManagement.mainMenu();
    }
    private static void saveData() {
        FileService.writeCustomersToCSV(dataManagement.getCustomers());
        FileService.writeProductsToCSV(
                dataManagement.getShirts(),
                dataManagement.getPants(),
                dataManagement.getShoes(),
                dataManagement.getSportsEquipments()
        );

    }
}
