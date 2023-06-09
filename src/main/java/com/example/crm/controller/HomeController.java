package com.example.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Controller Methods in the server to serve webpages

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/detail")
    public String detail() {
        return "detail";
    }
}
