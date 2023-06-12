package com.example.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalesController {

    // Show record sales page
    @GetMapping("/record-sales")
    public String recordSales() {
        return "dashboard/sales/salesOperations/record-sales";
    }

    // Show sales analytics page
    @GetMapping("/sales-analytics")
    public String salesAnalytics() {
        return "dashboard/sales/salesOperations/sales-analytics";
    }
}

