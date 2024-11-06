package model.service.impl;


import model.entity.Product;
import model.repository.IProductRepository;
import model.repository.impl.ProductRepository;
import model.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository repository = new ProductRepository();

    @Override
    public List<Product> findAllProducts() {
        return repository.getAllProducts();
    }

    @Override
    public Product findProductById(int id) {
        return null;
    }

    @Override
    public void createProduct(Product product) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(int id) {

    }
}