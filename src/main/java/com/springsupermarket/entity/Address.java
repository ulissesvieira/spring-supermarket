package com.springsupermarket.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "#{addressesRepository.getCollectionName()}")
public class Address {
    private Integer id;
    private String street;
    private String rsNumber;
    private String city;
    private String state;
    private String zip;

    public Address() {}

    public Address(Integer id, String street, String rsNumber, String city, String state, String zip) {
        this.id = id;
        this.street = street;
        this.rsNumber = rsNumber;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRsNumber() {
        return rsNumber;
    }

    public void setRsNumber(String rsNumber) {
        this.rsNumber = rsNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
