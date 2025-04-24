package com.mockbean.mockbean.repository;

import com.mockbean.mockbean.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    public Customer save(Customer customer);


    public Optional<Customer> findById(Integer custId);

    public void deleteById(Integer custId);
}
