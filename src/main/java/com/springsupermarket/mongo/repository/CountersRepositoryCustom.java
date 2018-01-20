package com.springsupermarket.mongo.repository;

public interface CountersRepositoryCustom {
    Integer getNextId(String sequenceName);
}
