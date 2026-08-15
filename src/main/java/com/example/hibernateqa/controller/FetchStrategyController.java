package com.example.hibernateqa.controller;

import com.example.hibernateqa.entity.Customer;
import com.example.hibernateqa.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hibernate/fetch")
public class FetchStrategyController {

    private final CustomerRepository customerRepository;

    public FetchStrategyController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
