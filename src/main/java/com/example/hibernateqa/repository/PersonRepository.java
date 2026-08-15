package com.example.hibernateqa.repository;

import com.example.hibernateqa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
