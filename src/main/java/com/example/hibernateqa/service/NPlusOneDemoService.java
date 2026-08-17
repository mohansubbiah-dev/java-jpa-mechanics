package com.example.hibernateqa.service;

import com.example.hibernateqa.entity.Customer;
import com.example.hibernateqa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NPlusOneDemoService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public List<Customer> getOrdersWithNPlusOneProblem() {
        List<Customer> customers = customerRepository.findAll();

        for (Customer customer : customers) {
            customer.getOrders().forEach(order -> {
                order.getItems().size();
            });
        }

        return customers;
    }

    @Transactional(readOnly = true)
    public List<Customer> getOrdersWithFetchJoinFix() {
        // single query: JOIN FETCH loads orders + items + products upfront
        return customerRepository.findAllWithOrdersAndItems();
    }
}
