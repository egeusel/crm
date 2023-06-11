package com.example.crm.service;

import com.example.crm.model.Customer;
import com.example.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Below is just written for good practice. We could have accessed the Repository directly from the
    // controller level but it is not a good practice. So in order to respect the abstraction barriers
    // we access controller --> service --> repository
    public List<Customer> searchCustomersByName(String name) {
        return customerRepository.findByName(name);
    }

    // Other CRUD operations...
}