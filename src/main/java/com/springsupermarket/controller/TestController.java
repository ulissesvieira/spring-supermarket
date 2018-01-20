package com.springsupermarket.controller;

import com.springsupermarket.entity.*;
import com.springsupermarket.mongo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private ClientsService clientsService;
    @Autowired
    private ItemsOrdersService itemsOrdersService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ProductsService productsService;

    @RequestMapping(method = RequestMethod.GET)
    public String t1() {
        Address address = new Address();
        address.setId(1);
        address.setCity("City");
        address.setRsNumber("1234");
        address.setState("State");
        address.setStreet("Street");
        address.setZip("zip");
        addressService.save(address);

        System.err.println(address.getId());

        address = new Address();
        address.setCity("City");
        address.setRsNumber("1234");
        address.setState("State");
        address.setStreet("Street");
        address.setZip("zip");
        addressService.save(address);

        Address a1 = new Address();
        a1.setId(2);
        List<Address> adr = addressService.getBy(a1);

        Client c = new Client();
        c.setId(100);
        c.setName("Cliente");
        clientsService.save(c);

        Product p = new Product();
        p.setId(12);
        p.setSku("PRD12345");
        p.setDescription("Product");
        productsService.save(p);

        Order o = new Order();
        o.setId(23423);
        o.setFirstTime(true);
        o.setDateCreated(new Date());
        o.setClient(c);
        ordersService.save(o);

        ItemsOrder item = new ItemsOrder();
        item.setId(87897);
        item.setOrder(o);
        item.setProduct(p);
        item.setPrice(45.65);
        item.setQuantity(1.5);
        itemsOrdersService.save(item);

        return "ORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORA";
    }
}
