package com.springsupermarket.mongo.repository;

import com.springsupermarket.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends MongoRepository<Client, Integer>, UtilsRepository {

}
