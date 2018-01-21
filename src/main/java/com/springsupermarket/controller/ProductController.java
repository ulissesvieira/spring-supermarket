package com.springsupermarket.controller;

import com.springsupermarket.entity.Product;
import com.springsupermarket.mongo.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {
    @Autowired
    private ProductsService productsService;

    @RequestMapping(name = "/products", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProducts() {
        return productsService.getAll();
    }
}
