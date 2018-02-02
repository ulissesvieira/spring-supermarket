package com.springsupermarket.mongo.service;

import com.springsupermarket.entity.Address;
import com.springsupermarket.mongo.repository.AddressesRepository;
import com.springsupermarket.mongo.repository.CountersRepository;
import com.springsupermarket.mongo.utils.MongoCollections;
import com.springsupermarket.mongo.utils.PaginationResult;
import com.springsupermarket.mongo.utils.PaginationSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        return addressesRepository.findByAny(address);
    }

    @Override
    public PaginationResult<Address> search(PaginationSettings settings) {
        Pageable pageable = new PageRequest(settings.getCurrentPage().intValue() - 1, settings.getItemsPerPage().intValue());
        Page<Address> page = addressesRepository.findAll(pageable);

        int startPage, endPage;
        int currentPage = settings.getCurrentPage();
        if (page.getTotalPages() <= 10) {
            // less than 10 total pages so show all
            startPage = 1;
            endPage = page.getTotalPages();
        } else {
            // more than 10 total pages so calculate start and end pages
            if (currentPage <= 6) {
                startPage = 1;
                endPage = 10;
            } else if (currentPage + 4 >= page.getTotalPages()) {
                startPage = page.getTotalPages() - 9;
                endPage = page.getTotalPages();
            } else {
                startPage = currentPage - 5;
                endPage = currentPage + 4;
            }
        }

        ArrayList<Integer> pages = new ArrayList<>();
        for (int i = startPage; i < endPage + 1; i++)
            pages.add(i);

        PaginationResult<Address> result = new PaginationResult<>();
        result.setItems(page.getContent());
        result.setTotalItems(page.getTotalElements());
        result.setTotalPages(page.getTotalPages());
        result.setCurrentPage(currentPage);
        result.setStartPage(startPage);
        result.setEndPage(endPage);
        result.setPageSize(settings.getItemsPerPage());
        result.setPages(pages.toArray(new Integer[pages.size()]));

        return result;
    }
}
