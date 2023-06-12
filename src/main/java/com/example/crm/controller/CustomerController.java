package com.example.crm.controller;

import com.example.crm.model.Customer;
import com.example.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Show add customer page
    @GetMapping("/add-customer")
    public String showAddCustomerPage() {
        return "dashboard/customers/customerOperations/add-customer";
    }

    @PostMapping("/save-customer")
    public String saveCustomer(String name, String email, String phoneNumber, String birthYear, RedirectAttributes redirectAttributes) {
        try {
            customerService.saveCustomer(name, email, phoneNumber, birthYear);
            redirectAttributes.addFlashAttribute("successMessage", "Customer added successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error adding customer. Please try again.");
        }
        return "redirect:/add-customer"; // <-- changed this
    }


    // Show search customer page
    @GetMapping("/search-customer")
    public String showSearchCustomerPage() {
        return "dashboard/customers/customerOperations/search-customer";
    }

    // Search for a customer by name
    @PostMapping("/search-customer")
    public String searchCustomer(@RequestParam("search") String search, Model model) {
        List<Customer> customers = customerService.searchCustomersByName(search);
        model.addAttribute("customers", customers);
        return "dashboard/customers/customerOperations/search-customer";
    }

    // Show update customer page
    @GetMapping("/update-customer")
    public String showUpdateCustomerPage() {
        return "dashboard/customers/customerOperations/update-customer";
    }

    // Update a customer
    @PostMapping("/update-customer")
    public String updateCustomer(@RequestParam Integer id,
                                 @RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String phoneNumber,
                                 RedirectAttributes redirectAttributes) {
        try {
            customerService.updateCustomer(id, name, email, phoneNumber);
            redirectAttributes.addFlashAttribute("success", "Customer updated successfully");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/update-customer";
    }

    // Show delete customer page
    @GetMapping("/delete-customer")
    public String showDeleteCustomerPage() {
        return "dashboard/customers/customerOperations/delete-customer";
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@RequestParam Integer customerId, RedirectAttributes redirectAttributes) {
        try {
            customerService.deleteCustomer(customerId);
            redirectAttributes.addFlashAttribute("success", "Customer deleted successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error deleting customer. Please check the customer ID and try again.");
        }
        return "redirect:/delete-customer";
    }

    @GetMapping("/view-all-customers")
    public String viewAllCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "dashboard/customers/customerOperations/view-all-customers";
    }
}
