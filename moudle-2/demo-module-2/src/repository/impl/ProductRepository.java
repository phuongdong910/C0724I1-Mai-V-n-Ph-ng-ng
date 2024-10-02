package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1,"Iphone 15", 3000d));
        products.add(new Product(2,"Samsung Galaxy S23", 4000d));
        products.add(new Product(3,"Sony Xperia Z3", 5000d));
        products.add(new Product(4,"Xiaomi mi10 Pro", 6000d));
    }


    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product: products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void delete(Product product) {
        products.remove(product);
    }

    @Override
    public void update(Product productEdit) {
        for (Product product: products) {
            if (product.getId() == productEdit.getId()) {
                product.setName(productEdit.getName());
                product.setPrice(productEdit.getPrice());
            }
        }
    }
}
