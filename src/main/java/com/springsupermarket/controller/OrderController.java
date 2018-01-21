package com.springsupermarket.controller;

import com.springsupermarket.entity.Order;
import com.springsupermarket.mongo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("list")
    public List<Order> getAll() {
        return ordersService.getAll();
    }

    @PostMapping("save")
    public Order save(@RequestBody Order order) {
        ordersService.save(order);
        return order;
    }

    @GetMapping("findById/{id}")
    public Order findById(@PathVariable("id") Integer id) {
        Order order = ordersService.findById(id);
        return order;
    }

    @PutMapping("update")
    public Order update(@RequestBody Order order) {
        ordersService.update(order);
        return order;
    }

    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        ordersService.delete(id);
        return true;
    }
}
