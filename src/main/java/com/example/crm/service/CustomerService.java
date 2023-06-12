package com.example.crm.service;

import com.example.crm.model.Customer;
import com.example.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void saveCustomer(String name, String email, String phoneNumber, String birthYear) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);

        customerRepository.save(customer);
    }

    // Below is just written for good practice. We could have accessed the Repository directly from the
    // controller level but it is not a good practice. So in order to respect the abstraction barriers
    // we access controller --> service --> repository
    public List<Customer> searchCustomersByName(String name) {
        return customerRepository.findByName(name);
    }

    @Transactional
    public void updateCustomer(Integer id, String name, String email, String phoneNumber) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid customer Id:" + id));
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customerRepository.save(customer);
    }

    @Transactional
    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);  // Note that we don't need to write anything in the CustomerRepository.
                                                    // The method deleteById is already provided by Spring Data JPA repositories
                                                    // by default
    }


}