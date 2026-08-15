package com.example.hibernateqa.service;

import com.example.hibernateqa.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntityLifecycleService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void runLifecycleDemo() {
        Customer customer = new Customer("Lifecycle Demo", "lifecycle@example.com");

        entityManager.persist(customer);
        customer.setName("Lifecycle Demo Updated");

        entityManager.flush();

        Customer detachedCustomer = customer;
        entityManager.detach(detachedCustomer);

        detachedCustomer.setName("Detached value should not persist");

        Customer merged = entityManager.merge(detachedCustomer);
        entityManager.remove(merged);
    }
}
