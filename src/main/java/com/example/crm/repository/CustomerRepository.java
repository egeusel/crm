package com.example.crm.repository;

import com.example.crm.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c WHERE c.name LIKE %:name%")
    List<Customer> findByName(@Param("name") String name);
    /*
    this is a JPQL (Java Persistence Query Language) query, not a native SQL query. In JPQL,
    we use the names of the Java classes and properties, not the names of the database tables
     and columns. So Customer is the name of the Java class that represents the customer entity,
      and name is the property in that class.
     */
}