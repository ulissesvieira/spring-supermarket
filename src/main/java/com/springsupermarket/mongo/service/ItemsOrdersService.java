package com.springsupermarket.mongo.service;

import com.springsupermarket.entity.ItemsOrder;

import java.util.List;

public interface ItemsOrdersService {
    ItemsOrder findById(Integer id);
    void save(ItemsOrder itemOrder);
    void update(ItemsOrder itemOrder);
    void delete(Integer id);

    List<ItemsOrder> getAll();
    List<ItemsOrder> getBy(ItemsOrder itemOrder);
}
