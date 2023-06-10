package com.example.crm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")  // This entity is mapped to "employees" table in crm_db database. JPA automatically
                            // INFERS THE CLASS NAME com.example.crm.model.Employee TO BE THE TABLE NAME, so we need to override it
                            // with actual table name "employees"
public class Employee {
    /*
        In JPA, there is a concept called object-relational mapping (ORM), which allows you to map the
        attributes of your Java object to the columns of a database table. While it's common to have a
        one-to-one mapping between the attributes and columns, it is not strictly required. Some of the
        below attributes may not be stored at all in the datatable and simply be present for the purposes
        of implementing the business logic
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Integer hireYear;

    // Getters and Setters...
}

