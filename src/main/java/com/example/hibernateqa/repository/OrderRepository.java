package com.example.hibernateqa.repository;

import com.example.hibernateqa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o join fetch o.customer c")
    List<Order> findAllWithCustomer();

    @Query("select distinct o from Order o " +
            "join fetch o.customer c " +
            "left join fetch o.items i " +
            "left join fetch i.product p")
    List<Order> findAllWithCustomerAndItems();
}
