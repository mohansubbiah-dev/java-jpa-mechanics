package com.example.hibernateqa.controller;

import com.example.hibernateqa.entity.Customer;
import com.example.hibernateqa.service.SqlInjectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hibernate/sqlinjection")
public class SqlInjectionController {

    private final SqlInjectionService service;

    public SqlInjectionController(SqlInjectionService service) {
        this.service = service;
    }

    // Try: /hibernate/sqlinjection/vulnerable?name=' OR '1'='1
    @GetMapping("/vulnerable")
    public List<Customer> vulnerable(@RequestParam String name) {
        return service.searchByNameUnsafe(name);
    }

    // Same payload here just matches (or fails to match) literally - no injection.
    @GetMapping("/fixed")
    public List<Customer> fixed(@RequestParam String name) {
        return service.searchByNameSafe(name);
    }
}
