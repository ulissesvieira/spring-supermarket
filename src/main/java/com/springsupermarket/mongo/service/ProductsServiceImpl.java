package com.springsupermarket.mongo.service;

import com.springsupermarket.entity.Product;
import com.springsupermarket.mongo.repository.CountersRepository;
import com.springsupermarket.mongo.repository.ProductsRepository;
import com.springsupermarket.mongo.utils.MongoCollections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private CountersRepository countersRepository;

    @Override
    public Product findById(Integer id) {
        Product product = productsRepository.findOne(id);
        return product;
    }

    @Override
    public void save(Product product) {
        Integer nextId = countersRepository.getNextId(MongoCollections.PRODUCTS.getSequenceName());
        product.setId(nextId);
        productsRepository.save(product);
    }

    @Override
    public void update(Product product) {
        Product prod = findById(product.getId());
        if (prod != null) {
            productsRepository.save(product);
        }
    }

    @Override
    public void delete(Integer id) {
        productsRepository.delete(id);
    }

    @Override
    public List<Product> getAll() {
        return productsRepository.findAll();
    }

    @Override
    public List<Product> getBy(Product product) {
        return productsRepository.findByAny(product, Product.class);
    }
}
