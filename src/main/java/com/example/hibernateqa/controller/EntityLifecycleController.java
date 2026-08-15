package com.example.hibernateqa.controller;

import com.example.hibernateqa.service.EntityLifecycleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hibernate/lifecycle")
public class EntityLifecycleController {

    private final EntityLifecycleService service;

    public EntityLifecycleController(EntityLifecycleService service) {
        this.service = service;
    }

    @GetMapping("/demo")
    public String demo() {
        service.runLifecycleDemo();
        return "Lifecycle demo executed successfully";
    }
}
