package com.springsupermarket.mongo.service;

import com.springsupermarket.entity.Order;

import java.util.List;

public interface OrdersService {
    Order findById(Integer id);
    void save(Order order);
    void update(Order order);
    void delete(Integer id);

    List<Order> getAll();
    List<Order> getBy(Order order);
}
