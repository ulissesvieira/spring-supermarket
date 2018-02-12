package com.springsupermarket.mongo.repository;

import java.util.List;

public interface UtilsRepository {
    <T> List<T> findByAny(T instance, Class<T> clazz);
    String getCollectionName();
}
