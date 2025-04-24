package com.mockbean.mockbean.service;

import com.mockbean.mockbean.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public Customer save(Customer customer);
   // public List<Customer> getAll();

    public Optional<Customer> findById(Integer custId);

    public void deleteById(Integer custId);
}
