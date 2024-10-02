package repository.impl;

import model.Product;
import repository.IProductRepository;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    private final String STUDENT_PATH_FILE = "F:\\Codegym-dao-tao\\module-2\\demo-mvc\\demo-mvc\\src\\service\\product.txt";

    @Override
    public void save(Product product) {
        List<Product> products = readDataFromFile(STUDENT_PATH_FILE);
        products.add(product);
//        FileService.writeProduct(STUDENT_PATH_FILE, products);
        writeToFile(STUDENT_PATH_FILE, products);
    }

    @Override
    public List<Product> findAll() {
//        return FileService.readProduct(STUDENT_PATH_FILE);
        return readDataFromFile(STUDENT_PATH_FILE);
    }

    public  void writeToFile(String path, List<Product> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  List<Product> readDataFromFile(String path){
        List<Product> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
}
