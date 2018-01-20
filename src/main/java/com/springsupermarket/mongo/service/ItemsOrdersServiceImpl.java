package com.springsupermarket.mongo.service;

import com.springsupermarket.entity.ItemsOrder;
import com.springsupermarket.mongo.repository.CountersRepository;
import com.springsupermarket.mongo.repository.ItemsOrdersRepository;
import com.springsupermarket.mongo.utils.MongoCollections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsOrdersServiceImpl implements ItemsOrdersService {
    @Autowired
    private ItemsOrdersRepository itemsOrdersRepository;
    @Autowired
    private CountersRepository countersRepository;

    @Override
    public ItemsOrder findById(Integer id) {
        ItemsOrder item = itemsOrdersRepository.findOne(id);
        return item;
    }

    @Override
    public void save(ItemsOrder itemOrder) {
        Integer nextId = countersRepository.getNextId(MongoCollections.ITEMS_ORDERS.getSequenceName());
        itemOrder.setId(nextId);
        itemsOrdersRepository.save(itemOrder);
    }

    @Override
    public void update(ItemsOrder itemOrder) {
        ItemsOrder item = findById(itemOrder.getId());
        if (item != null) {
            itemsOrdersRepository.save(itemOrder);
        }
    }

    @Override
    public void delete(Integer id) {
        itemsOrdersRepository.delete(id);
    }

    @Override
    public List<ItemsOrder> getAll() {
        return itemsOrdersRepository.findAll();
    }

    @Override
    public List<ItemsOrder> getBy(ItemsOrder itemOrder) {
        return itemsOrdersRepository.findByAny(itemOrder);
    }
}
