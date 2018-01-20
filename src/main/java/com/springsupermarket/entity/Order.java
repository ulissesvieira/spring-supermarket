package com.springsupermarket.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "#{ordersRepository.getCollectionName()}")
public class Order {
	private Integer id;
	private Client client;
	private Date dateCreated;
	private Boolean firstTime;

	public Order() {}

	public Order(Integer id, Client client, Date dateCreated, Boolean firstTime) {
		this.id = id;
		this.client = client;
		this.dateCreated = dateCreated;
		this.firstTime = firstTime;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Boolean getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(Boolean firstTime) {
		this.firstTime = firstTime;
	}	
}
