package com.springsupermarket.mongo.service;

import com.springsupermarket.mongo.entiry.Counters;
import com.springsupermarket.mongo.repository.CountersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountersServiceImpl implements CountersService {
    @Autowired
    private CountersRepository repository;

    @Override
    public void saveAndModify(Counters counter) {
        repository.save(counter);
    }
}
