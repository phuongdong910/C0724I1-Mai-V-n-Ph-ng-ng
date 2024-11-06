package model.repository;

import java.util.List;

public interface IProductRepository {

    void insertProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);

    Product getProductById(int id);

    List<Product> getAllProducts();
}
