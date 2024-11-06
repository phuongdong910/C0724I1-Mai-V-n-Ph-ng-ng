package com.example.demousermanagement.service;

import com.example.demousermanagement.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void save ( Customer customer);
    Customer findById (int id);
    void update (int id,  Customer customer);
    void remove  (int id);
}
