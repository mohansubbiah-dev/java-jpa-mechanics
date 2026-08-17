package com.example.hibernateqa.repository;

import com.example.hibernateqa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select distinct c from Customer c " +
            "left join fetch c.orders o " +
            "left join fetch o.items i " +
            "left join fetch i.product p")
    List<Customer> findAllWithOrdersAndItems();
}
