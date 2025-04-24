package com.mockbean.mockbean.controller;

import com.mockbean.mockbean.entity.Customer;
import com.mockbean.mockbean.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<Customer> save( @RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }
   /* @GetMapping("/findAll")
    public List<Customer> findAll() {

        List<Customer> customers = customerService.getAll();
        return  customers;
    }*/
    @GetMapping("/findById/{custId}")
    public  ResponseEntity<Customer> findById(@PathVariable Integer custId){
        return customerService.findById(custId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }
    @DeleteMapping("/delete/{custId}")
    public void deleteCustById( @PathVariable Integer custId){
        customerService.deleteById(custId);
    }
}
