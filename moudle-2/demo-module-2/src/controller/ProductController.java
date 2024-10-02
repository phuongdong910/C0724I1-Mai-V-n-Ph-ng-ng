package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductService;

import java.util.List;

public class ProductController {
    private IProductService productService = new ProductService();

    public List<Product> findAll() {
        return this.productService.findAll();
    }

    public void save(Product product) {
        this.productService.save(product);
    }

    public Product findById(int id) {
        return this.productService.findById(id);
    }

    public void delete(Product product) {
        this.productService.delete(product);
    }

    public void update(Product productEdit) {
        this.productService.update(productEdit);
    }
}
