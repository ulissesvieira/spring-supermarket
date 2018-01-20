package com.springsupermarket.mongo.repository;

import com.springsupermarket.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends MongoRepository<Order, Integer>, UtilsRepository {
}
