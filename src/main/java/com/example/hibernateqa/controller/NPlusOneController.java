package com.example.hibernateqa.controller;

import com.example.hibernateqa.entity.Customer;
import com.example.hibernateqa.entity.Order;
import com.example.hibernateqa.service.NPlusOneDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hibernate/nplusone")
public class NPlusOneController {

    private final NPlusOneDemoService service;

    public NPlusOneController(NPlusOneDemoService service) {
        this.service = service;
    }

    @GetMapping("/bad")
    public List<Customer> bad() {
        return service.getOrdersWithNPlusOneProblem();
    }

    @GetMapping("/fixed")
    public List<Customer> fixed() {
        return service.getOrdersWithFetchJoinFix();
    }
}
