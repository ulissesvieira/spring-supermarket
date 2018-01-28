package com.springsupermarket.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.springsupermarket.mongo.repository.AddressesRepository;
import com.springsupermarket.mongo.repository.ProductsRepository;
import com.springsupermarket.mongo.service.AddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses=ProductsRepository.class)
@ComponentScan(basePackageClasses = {
        AddressesService.class,
        AddressesRepository.class})
public class MongoConfig extends AbstractMongoConfiguration {
	@Autowired
	private Environment env;

	@Override
	protected String getDatabaseName() {		
		return env.getProperty("mongo.database.name");
	}

	@Override
	public Mongo mongo() throws Exception {		
		return new MongoClient(env.getProperty("mongo.database.ip"), 27017);
	}	
}
