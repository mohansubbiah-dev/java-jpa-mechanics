package com.example.hibernateqa.service;

import com.example.hibernateqa.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NPlusOneDemoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Order> getOrdersWithNPlusOneProblem() {
        List<Order> orders = entityManager.createQuery(
                "select o from Order o", Order.class
        ).getResultList();

        for (Order order : orders) {
            order.getCustomer().getName();
            order.getItems().size();
        }

        return orders;
    }

    @Transactional(readOnly = true)
    public List<Order> getOrdersWithFetchJoinFix() {
        return entityManager.createQuery(
                "select distinct o from Order o " +
                "join fetch o.customer c " +
                "left join fetch o.items i " +
                "left join fetch i.product p",
                Order.class
        ).getResultList();
    }
}
