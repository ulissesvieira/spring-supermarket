package com.springsupermarket.mongo;

public enum MongoCollections {
    ADDRESS("address", "seq_address"),
    CLIENTS("clients", "seq_clients"),
    ITEMS_ORDERS("items_orders", "seq_items_orders"),
    ORDERS("orders", "seq_orders"),
    PRODUCTS("products", "seq_products"),
    COUNTERS("counters", "seq_counters");

    private String name;
    private String sequenceName;

    MongoCollections(String name, String sequenceName) {
        this.name = name;
        this.sequenceName = sequenceName;
    }

    public String getName() {
        return name;
    }

    public String getSequenceName() {
        return sequenceName;
    }
}
