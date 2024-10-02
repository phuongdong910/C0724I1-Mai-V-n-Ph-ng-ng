package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductService;

import java.util.List;

public class ProductController {
    private final IProductService productService = new ProductService();

    public void addNewProduct(Product product) {
        this.productService.save(product);
    }

    public List<Product> findAll() {
        return this.productService.findAll();
    }
}
