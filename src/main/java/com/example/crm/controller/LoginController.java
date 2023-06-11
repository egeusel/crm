package com.example.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // Rendering the login page itself
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /* In the case of the login functionality, Spring Security typically handles the
       actual authentication process automatically, so you don't usually need to write
       a custom @PostMapping method for the login form submission.
     */
}