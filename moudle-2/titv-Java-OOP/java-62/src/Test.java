import java.util.*;

public class Test {
    public static void main(String[] args) {
       Map<String, Double> laptopMaps = new HashMap<String, Double >();

       laptopMaps.put("Dell", 15000.0);
       laptopMaps.put("Asus", 17000.0);
       laptopMaps.put("HP", 15750.0);
       laptopMaps.put("Lenovo", 25000.0);

        System.out.println("Tập hợp các loại laptop  là: " + laptopMaps.toString());

    }
}
