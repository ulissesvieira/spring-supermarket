package com.springsupermarket.controller;

import com.springsupermarket.entity.Address;
import com.springsupermarket.mongo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private AddressService addressService;

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

        return "ORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORAORA";
    }
}
