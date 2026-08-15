package com.example.hibernateqa.controller;

import com.example.hibernateqa.entity.Employee;
import com.example.hibernateqa.entity.Manager;
import com.example.hibernateqa.repository.PersonRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hibernate/inheritance")
public class InheritanceController {

    private final PersonRepository personRepository;

    public InheritanceController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/employee")
    public String saveEmployee() {
        Employee employee = new Employee();
        employee.setName("John Employee");
        employee.setDepartmentName("Engineering");
        personRepository.save(employee);
        return "Employee saved";
    }

    @PostMapping("/manager")
    public String saveManager() {
        Manager manager = new Manager();
        manager.setName("Mary Manager");
        manager.setManagerName("Engineering");
        personRepository.save(manager);
        return "Manager saved";
    }
}
