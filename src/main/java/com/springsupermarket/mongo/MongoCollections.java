package com.springsupermarket.mongo;

public enum MongoCollections {
    ADDRESS("address"),
    CLIENTS("clients"),
    ITEMS_ORDERS("items_orders"),
    ORDERS("orders"),
    PRODUCTS("products");

    private String name;

    MongoCollections(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
