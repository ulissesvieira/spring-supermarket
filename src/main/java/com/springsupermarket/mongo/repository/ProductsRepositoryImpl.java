package com.springsupermarket.mongo.repository;

import com.springsupermarket.mongo.utils.MongoCollections;
import com.springsupermarket.mongo.utils.SearchUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class ProductsRepositoryImpl implements UtilsRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    private final String COLLECTION_NAME = MongoCollections.PRODUCTS.getName();

    @Override
    public <T> List<T> findByAny(T instance) {
        Class clazz = instance.getClass();
        Criteria criteria = SearchUtils.anyFieldCriteria(clazz, instance);

        Query query = Query.query(criteria);
        List<T> list = mongoTemplate.find(query, clazz, COLLECTION_NAME);

        return list;
    }

    @Override
    public String getCollectionName() {
        return COLLECTION_NAME;
    }
}
