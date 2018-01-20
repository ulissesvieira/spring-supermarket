package com.springsupermarket.mongo.repository;

import com.springsupermarket.mongo.MongoCollections;
import com.springsupermarket.mongo.entiry.Counters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class CountersRepositoryImpl implements CountersRepositoryCustom {
    @Autowired
    private MongoTemplate mongoTemplate;

    private final String COLLECTION_NAME = MongoCollections.COUNTERS.getName();

    @Override
    public Integer getNextId(String sequenceName) {
        Query query = Query.query(Criteria.where("sequenceName").is(sequenceName));
        Update update = new Update().inc("sequenceValue", 1);

        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);
        options.upsert(true);

        Counters counter = mongoTemplate.findAndModify(query, update, options, Counters.class, COLLECTION_NAME);

        return counter.getSequenceValue();
    }
}
