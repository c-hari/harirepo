package com.mockbean.mockbean.service;


import com.mockbean.mockbean.entity.Customer;
import com.mockbean.mockbean.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements  CustomerService{
    @Autowired
    CustomerRepository repository;
    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Integer custId) {
        return repository.findById(custId);
    }

    @Override
    public void deleteById(Integer custId) {
        repository.deleteById(custId);
    }

}
