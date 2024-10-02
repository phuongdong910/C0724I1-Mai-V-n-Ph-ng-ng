package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {

    private final IProductRepository productRepository = new ProductRepository();

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }
}
