package com.springsupermarket.controller;

import com.springsupermarket.entity.Address;
import com.springsupermarket.mongo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("list")
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @PostMapping("save")
    public Address save(@RequestBody Address address) {
        addressService.save(address);
        return address;
    }

    @GetMapping("findById/{id}")
    public Address findById(@PathVariable("id") Integer id) {
        Address address = addressService.findById(id);
        return address;
    }

    @PutMapping("update")
    public Address update(@RequestBody Address address) {
        addressService.update(address);
        return address;
    }

    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        addressService.delete(id);
        return true;
    }
}
