package com.springsupermarket.controller;

import com.springsupermarket.entity.ItemsOrder;
import com.springsupermarket.mongo.service.ItemsOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/itemsOrder", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemsOrderController {
    @Autowired
    private ItemsOrdersService itemsOrdersService;

    @GetMapping("list")
    public List<ItemsOrder> getAll() {
        return itemsOrdersService.getAll();
    }

    @PostMapping("save")
    public ItemsOrder save(@RequestBody ItemsOrder itemOrder) {
        itemsOrdersService.save(itemOrder);
        return itemOrder;
    }

    @GetMapping("findById/{id}")
    public ItemsOrder findById(@PathVariable("id") Integer id) {
        ItemsOrder itemOrder = itemsOrdersService.findById(id);
        return itemOrder;
    }

    @PutMapping("update")
    public ItemsOrder update(@RequestBody ItemsOrder itemOrder) {
        itemsOrdersService.update(itemOrder);
        return itemOrder;
    }

    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        itemsOrdersService.delete(id);
        return true;
    }
}
