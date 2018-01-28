package com.springsupermarket.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "#{clientsRepository.getCollectionName()}")
public class Client {
	private Integer id;
	private String name;
	private Date birthday;

	public Client() {}

	public Client(Integer id, String name, Date birthday) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
