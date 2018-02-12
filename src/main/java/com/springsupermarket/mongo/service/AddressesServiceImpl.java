package com.springsupermarket.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springsupermarket.entity.Address;
import com.springsupermarket.mongo.repository.AddressesRepository;
import com.springsupermarket.mongo.repository.CountersRepository;
import com.springsupermarket.mongo.utils.MongoCollections;
import com.springsupermarket.mongo.utils.PaginationResult;
import com.springsupermarket.mongo.utils.PaginationSettings;

@Service
public class AddressesServiceImpl implements AddressesService {
    @Autowired
    private AddressesRepository addressesRepository;
    @Autowired
    private CountersRepository countersRepository;

    @Override
    public Address findById(Integer id) {
        Address addr = addressesRepository.findOne(id);
        return addr;
    }

    @Override
    public void save(Address address) {
        Integer nextId = countersRepository.getNextId(MongoCollections.ADDRESSES.getSequenceName());
        address.setId(nextId);
        addressesRepository.save(address);
    }

    @Override
    public void update(Address address) {
        Address addr = findById(address.getId());
        if (addr != null) {
            addressesRepository.save(address);
        }
    }

    @Override
    public void delete(Integer id) {
        addressesRepository.delete(id);
    }

    @Override
    public List<Address> getAll() {
        return addressesRepository.findAll();
    }

    @Override
    public List<Address> getBy(Address address) {
        return addressesRepository.findByAny(address, Address.class);
    }

    @Override
    public PaginationResult<Address> search(PaginationSettings settings) {
        Pageable pageable = new PageRequest(settings.getCurrentPage().intValue() - 1, settings.getItemsPerPage().intValue());
        Page<Address> page = addressesRepository.findAll(pageable);

        return new PaginationResult<Address>(page);
    }
}
