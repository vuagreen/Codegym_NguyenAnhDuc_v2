package com.codegym.demo.service.Impl;

import com.codegym.demo.model.Product;
import com.codegym.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;
    static {
        products=new HashMap<>();
        products.put(1, new Product(1, "Iphone 7", 1000, "Iphone 2017", "Apple"));
        products.put(2, new Product(2, "Iphone 8", 1200, "Iphone 2018", "Apple"));
        products.put(3, new Product(3, "Iphone 10", 1500, "Iphone 2019", "Apple"));
        products.put(4, new Product(4, "Samsung Galaxy", 500, "model 2015", "Samsung"));
        products.put(5, new Product(5, "Oppo A3", 800, "Oppo 2017", "Oppo"));
        products.put(6, new Product(6, "Oppo R5", 1000, "abc xyz", "Oppo"));

    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
