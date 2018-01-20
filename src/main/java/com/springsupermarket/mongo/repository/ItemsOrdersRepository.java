package com.springsupermarket.mongo.repository;

import com.springsupermarket.entity.ItemsOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsOrdersRepository extends MongoRepository<ItemsOrder, Integer>, UtilsRepository {
}
