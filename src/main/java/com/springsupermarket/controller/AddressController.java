package com.springsupermarket.controller;

import com.springsupermarket.entity.Address;
import com.springsupermarket.mongo.service.AddressesService;
import com.springsupermarket.mongo.utils.PaginationResult;
import com.springsupermarket.mongo.utils.PaginationSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController {
    @Autowired
    private AddressesService addressesService;

    @GetMapping("list")
    public List<Address> getAll() {
        return addressesService.getAll();
    }

    @GetMapping("search")
    PaginationResult<Address> search(@RequestParam("currentPage") Integer currentPage, @RequestParam("itemsPerPage") Integer itemsPerPage) {
        PaginationSettings settings = new PaginationSettings();
        settings.setCurrentPage(currentPage);
        settings.setItemsPerPage(itemsPerPage);

        return addressesService.search(settings);
    }

    @GetMapping("search2")
    PaginationResult<Address> search2(@RequestBody PaginationSettings settings) {
        return addressesService.search(settings);
    }

    @PostMapping("save")
    public Address save(@RequestBody Address address) {
        addressesService.save(address);
        return address;
    }

    @GetMapping("findById/{id}")
    public Address findById(@PathVariable("id") Integer id) {
        Address address = addressesService.findById(id);
        return address;
    }

    @PutMapping("update")
    public Address update(@RequestBody Address address) {
        addressesService.update(address);
        return address;
    }

    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        addressesService.delete(id);
        return true;
    }
}
