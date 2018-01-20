package com.springsupermarket.mongo.repository;

import com.springsupermarket.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Address, Integer>, UtilsRepository {
}
