package com.tybootcamp.ecomm.controllers;

import com.tybootcamp.ecomm.entities.Customer;
import com.tybootcamp.ecomm.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    // Add new Customer
    @PostMapping(path = "/")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){
        Customer createdCustomer = customerService.addNewCustomer(customer);

        return new ResponseEntity<>(createdCustomer, HttpStatus.OK);
    }
    // Update Customer
    // Delete Customer
    // Get Customer By ID
    // Get Customer By Name
    @GetMapping(path = "/")
    public ResponseEntity<Customer> findCustomerByName(@RequestParam(value = "name") String name){
        Customer customer = customerService.getCustomerByName(name); // Missing control if such customer exist or not
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


}
