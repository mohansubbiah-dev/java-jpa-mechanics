package com.example.hibernateqa.service;

import com.example.hibernateqa.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Demonstrates how building a native SQL query by string concatenation
 * lets user input change the query's structure (SQL injection), and how
 * binding the same input as a parameter closes that hole.
 *
 * Try payload: name = "' OR '1'='1" against /vulnerable vs /fixed.
 */
@Service
public class SqlInjectionService {

    private static final Logger log = LoggerFactory.getLogger(SqlInjectionService.class);

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * VULNERABLE: the search term is concatenated straight into the SQL text.
     * An input like {@code ' OR '1'='1} turns the WHERE clause into a tautology
     * and returns every customer instead of matching by name.
     */
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Customer> searchByNameUnsafe(String name) {
        String sql = "SELECT * FROM customer WHERE name = '" + name + "'";
        log.warn("[UNSAFE]  executing concatenated SQL: {}", sql);

        Query query = entityManager.createNativeQuery(sql, Customer.class);
        return query.getResultList();
    }

    /**
     * FIXED: the search term is bound as a query parameter, so the driver
     * always treats it as data, never as part of the SQL grammar.
     */
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Customer> searchByNameSafe(String name) {
        String sql = "SELECT * FROM customer WHERE name = ?1";
        log.info("[SAFE]    executing parameterized SQL: {} with bound name='{}'", sql, name);

        Query query = entityManager.createNativeQuery(sql, Customer.class);
        query.setParameter(1, name);
        return query.getResultList();
    }
}
