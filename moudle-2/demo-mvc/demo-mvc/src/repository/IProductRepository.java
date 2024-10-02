package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    void save(Product product);

    List<Product> findAll();
}
