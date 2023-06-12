package com.example.crm.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String viewDashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        // Pass the username to the model
        model.addAttribute("username", userDetails.getUsername());
        return "dashboard/dashboard";
}

    // Navigating to customers.html when clicking on the first image on the dashboard
    @GetMapping("/customers")
    public String viewCustomers() {
        return "dashboard/customers/customers";
    }

    // Navigating to sales.html when clicking on the second image on the dashboard
    @GetMapping("/sales")
    public String viewSales() {
        return "dashboard/sales/sales";
    }
}

