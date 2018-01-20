package com.springsupermarket.mongo.repository;

import com.springsupermarket.entity.Address;

import java.util.List;

public interface AddressRepositoryCustom {
    List<Address> findByAny(Address address);
}
