package service;

import model.Product;

import java.util.List;

public interface IProductService {
    void save(Product product);

    List<Product> findAll();
}
