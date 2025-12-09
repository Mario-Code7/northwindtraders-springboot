package com.pluralsight.NorthwindTradersSpringBoot.data;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAll();
    void add(Product product);


    void update(Product product);
    void delete(Product product);
    List<Product> searchByProduct(String keyword);
}
