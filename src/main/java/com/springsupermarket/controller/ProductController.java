package com.springsupermarket.controller;

import com.springsupermarket.entity.Product;
import com.springsupermarket.mongo.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("list")
    public List<Product> getAll() {
        return productsService.getAll();
    }

    @PostMapping("save")
    public Product save(@RequestBody Product product) {
        productsService.save(product);
        return product;
    }

    @GetMapping("findById/{id}")
    public Product findById(@PathVariable("id") Integer id) {
        Product prod = productsService.findById(id);
        return prod;
    }

    @PutMapping("update")
    public Product update(@RequestBody Product product) {
        productsService.update(product);
        return product;
    }

    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        productsService.delete(id);
        return true;
    }
}
