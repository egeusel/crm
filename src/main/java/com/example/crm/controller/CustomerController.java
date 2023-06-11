package com.example.crm.controller;

import com.example.crm.model.Customer;
import com.example.crm.repository.CustomerRepository;
import com.example.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/customers")  // all the methods inside the controller will be mapped with the URLs that start with /customers
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save-customer")   // Matches the action attribute in html: <form action="/customers/save-customer" method="post" class="mt-4">
    public String saveCustomer(String name, String email, String phoneNumber, String birthYear) {
        customerService.saveCustomer(name, email, phoneNumber, birthYear);
        return "redirect:/dashboard";
    }

    @PostMapping("/search-customer")
    public String searchCustomer(@RequestParam("search") String search, Model model) {
        List<Customer> customers = customerService.searchCustomersByName(search);
        model.addAttribute("customers", customers);
        return "search-customer";
    }

// You can add other methods to handle different CRUD operations later
}