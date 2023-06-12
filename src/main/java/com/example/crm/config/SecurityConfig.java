package com.example.crm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity // Enable Spring Security
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired // Inject UserDetailsService for user authentication
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/register", "/dashboard/**", "/customers/**") // Specify the URLs that can be accessed without authentication
                .permitAll()
                .anyRequest().authenticated() // Any request not mentioned above must be authenticated
                .and()
                .formLogin()
                .loginPage("/") // Specify the URL of the login form
                .loginProcessingUrl("/login") // Specify the URL to submit the login form
                .defaultSuccessUrl("/dashboard", true) // Specify the default URL to redirect to after a successful login
                .permitAll() // Allow all users (even unauthenticated) to access the login form
                .and()
                .logout() // Configures logout functionality
                .permitAll() // Allow all users to perform a logout
                .and()
                .csrf().disable(); // Disable CSRF protection (not recommended for production)
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Configure the authentication manager builder with the userDetailsService and password encoder
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // Bean for the password encoder. BCrypt is a good choice for securely hashing passwords.
        return new BCryptPasswordEncoder();
    }
}