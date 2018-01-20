package com.springsupermarket.mongo.service;

import com.springsupermarket.entity.Address;
import com.springsupermarket.mongo.MongoCollections;
import com.springsupermarket.mongo.repository.AddressRepository;
import com.springsupermarket.mongo.repository.CountersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository repository;
    @Autowired
    private CountersRepository countersRepository;

    @Override
    public Address findById(Integer id) {
        Address addr = repository.findOne(id);
        return addr;
    }

    @Override
    public void save(Address address) {
        Integer nextId = countersRepository.getNextId(MongoCollections.ADDRESS.getSequenceName());
        address.setId(nextId);
        repository.save(address);
    }

    @Override
    public void update(Address address) {
        Address addr = findById(address.getId());
        if (addr != null) {
            repository.save(address);
        }
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public List<Address> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Address> getBy(Address address) {
        return repository.findByAny(address);
    }
}
