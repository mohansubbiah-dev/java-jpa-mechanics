package com.example.hibernateqa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hibernate")
public class HibernateQuestionCatalogController {

    @GetMapping("/questions")
    public List<Map<String, String>> questions() {
        return List.of(
                Map.of("topic", "N+1 issue", "url", "/hibernate/nplusone/bad"),
                Map.of("topic", "N+1 fixed", "url", "/hibernate/nplusone/fixed"),
                Map.of("topic", "Entity lifecycle", "url", "/hibernate/lifecycle/demo"),
                Map.of("topic", "Lazy vs Eager", "url", "/hibernate/fetch/customers"),
                Map.of("topic", "Optimistic locking", "url", "/hibernate/locking/deposit/{id}?amount=100"),
                Map.of("topic", "Inheritance mapping", "url", "/hibernate/inheritance/employee"),
                Map.of("topic", "First-level cache", "url", "/hibernate/cache/product/{id}")
        );
    }
}
