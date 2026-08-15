package com.example.hibernateqa.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("EMP")
public class Employee extends Person {

    @Column(name = "department_name")
    private String departmentName;

    public Employee() {
    }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
}
