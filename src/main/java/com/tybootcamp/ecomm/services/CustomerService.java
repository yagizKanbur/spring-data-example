package com.tybootcamp.ecomm.services;

import com.tybootcamp.ecomm.entities.Customer;
import com.tybootcamp.ecomm.entities.Profile;
import com.tybootcamp.ecomm.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer addNewCustomer(String name){
        Customer customer = new Customer(name);
        Profile profile = new Profile(customer); // Change here
        customer.setProfile(profile);
        customerRepository.save(customer);
        return  customer;
    }

    public Customer addNewCustomer(Customer customer){
        Customer createdCustomer = customerRepository.save(customer);
        return createdCustomer;
    }

    public void deleteCustomer(Customer customer){
        customerRepository.delete(customer);
    }

    public void deleteCustomerById (Long customerId){
        customerRepository.deleteById(customerId);
    }

    public Customer getCustomerByName (String customerName){
        return customerRepository.findByName(customerName);
    }


}
