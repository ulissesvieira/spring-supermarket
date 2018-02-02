package com.springsupermarket.mongo.service;

import com.springsupermarket.entity.Address;
import com.springsupermarket.mongo.utils.PaginationResult;
import com.springsupermarket.mongo.utils.PaginationSettings;

import java.util.List;

public interface AddressesService {
    Address findById(Integer id);
    void save(Address address);
    void update(Address address);
    void delete(Integer id);

    List<Address> getAll();
    List<Address> getBy(Address address);
    PaginationResult<Address> search(PaginationSettings settings);
}
