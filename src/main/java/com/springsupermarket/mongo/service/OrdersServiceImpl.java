package com.springsupermarket.mongo.service;

import com.springsupermarket.entity.Order;
import com.springsupermarket.mongo.repository.CountersRepository;
import com.springsupermarket.mongo.repository.OrdersRepository;
import com.springsupermarket.mongo.utils.MongoCollections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private CountersRepository countersRepository;

    @Override
    public Order findById(Integer id) {
        Order order = ordersRepository.findOne(id);
        return order;
    }

    @Override
    public void save(Order order) {
        Integer nextId = countersRepository.getNextId(MongoCollections.ORDERS.getSequenceName());
        order.setId(nextId);
        ordersRepository.save(order);
    }

    @Override
    public void update(Order order) {
        Order ord = findById(order.getId());
        if (ord != null) {
            ordersRepository.save(order);
        }
    }

    @Override
    public void delete(Integer id) {
        ordersRepository.delete(id);
    }

    @Override
    public List<Order> getAll() {
        return ordersRepository.findAll();
    }

    @Override
    public List<Order> getBy(Order order) {
        return ordersRepository.findByAny(order);
    }
}
