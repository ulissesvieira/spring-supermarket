package com.springsupermarket.mongo.service;

import com.springsupermarket.mongo.entiry.Counters;

public interface CountersService {
    void saveAndModify(Counters counter);
}
