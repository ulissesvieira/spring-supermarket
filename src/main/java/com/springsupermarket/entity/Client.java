package com.springsupermarket.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "#{clientsRepository.getCollectionName()}")
public class Client {
	private Integer id;
	private String name;

	public Client() {}

	public Client(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
