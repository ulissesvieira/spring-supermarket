package com.springsupermarket.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "#{productsRepository.getCollectionName()}")
public class Product {
	private Integer id;
	private String sku;
	private String description;

	public Product() {}

	public Product(Integer id, String sku, String description) {
		this.id = id;
		this.sku = sku;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
}
