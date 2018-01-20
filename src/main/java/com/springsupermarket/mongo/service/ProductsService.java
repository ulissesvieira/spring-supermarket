package com.springsupermarket.mongo.service;

import com.springsupermarket.entity.Product;

import java.util.List;

public interface ProductsService {
    Product findById(Integer id);
    void save(Product product);
    void update(Product product);
    void delete(Integer id);

    List<Product> getAll();
    List<Product> getBy(Product product);
}
