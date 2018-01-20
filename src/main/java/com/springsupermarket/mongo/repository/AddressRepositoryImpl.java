package com.springsupermarket.mongo.repository;

import com.springsupermarket.entity.Address;
import com.springsupermarket.mongo.MongoCollections;
import com.springsupermarket.mongo.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class AddressRepositoryImpl implements AddressRepositoryCustom {
    @Autowired
    private MongoTemplate mongoTemplate;

    private final String COLLECTION_NAME = MongoCollections.ADDRESS.getName();

    @Override
    public List<Address> findByAny(Address address) {
        Criteria criteria = Utils.anyFieldCriteria(Address.class, address);
        Query query = Query.query(criteria);
        List<Address> list = mongoTemplate.find(query, Address.class, COLLECTION_NAME);

        return list;
    }
}
