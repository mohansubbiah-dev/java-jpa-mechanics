package com.example.hibernateqa.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("MGR")
public class Manager extends Person {

    @Column(name = "manager_name")
    private String managerName;

    public Manager() {
    }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
}
