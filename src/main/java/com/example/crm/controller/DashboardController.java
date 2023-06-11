package com.example.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {


    @GetMapping // This will map to /dashboard
    public String dashboard() {
        return "dashboard"; // This should return the dashboard view (e.g. dashboard.html)
    }

    @GetMapping("/add-customer")
    public String showAddCustomerPage() {
        return "add-customer";
    }

    @GetMapping("/search-customer")
    public String showSearchCustomerPage() {
        return "search-customer";
    }

    @GetMapping("/update-customer")
    public String showUpdateCustomerPage() {
        return "update-customer";
    }

    @GetMapping("/delete-customer")
    public String showDeleteCustomerPage() {
        return "delete-customer";
    }

    @GetMapping("/view-reports")
    public String showViewReportsPage() {
        return "view-reports";
    }
}

