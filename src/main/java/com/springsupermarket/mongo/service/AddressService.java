package com.springsupermarket.mongo.service;

import com.springsupermarket.entity.Address;
import com.springsupermarket.entity.Product;

import java.util.List;

public interface AddressService {
    Address findById(Integer id);
    void save(Address address);
    void update(Address address);
    void delete(Integer id);

    List<Address> getAll();
    List<Address> getBy(Address address);
}
