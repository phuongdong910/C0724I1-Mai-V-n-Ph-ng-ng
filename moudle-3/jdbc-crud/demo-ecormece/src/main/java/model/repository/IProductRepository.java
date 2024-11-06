package model.repository;

import model.entities.Product;
import java.util.List;

public interface IProductRepository {
    List<Product> getAllProducts();
    Product getProductById(int productId);
    boolean saveProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(int productId);
    boolean editProduct(Product product);
}