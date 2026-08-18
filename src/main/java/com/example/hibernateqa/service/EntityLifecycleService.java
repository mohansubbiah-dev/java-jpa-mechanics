package com.example.hibernateqa.service;

import com.example.hibernateqa.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Demonstrates how a JPA entity moves through the four lifecycle states —
 * Transient, Managed, Detached and Removed — and how the persistence
 * context reacts (or stops reacting) to changes at each stage.
 */
@Service
public class EntityLifecycleService {

    private static final Logger log = LoggerFactory.getLogger(EntityLifecycleService.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void runLifecycleDemo() {
        // TRANSIENT: not yet known to the persistence context, no identity in the DB.
        Customer customer = new Customer("Lifecycle Demo", "lifecycle@example.com");
        log.info("[TRANSIENT]  new Customer created, managed={}", entityManager.contains(customer));

        // MANAGED: persist() attaches the entity to the persistence context.
        entityManager.persist(customer);
        log.info("[MANAGED]    persist() called, id={}, managed={}", customer.getId(), entityManager.contains(customer));

        // MANAGED: field changes on a managed entity are auto-detected by dirty checking.
        customer.setName("Lifecycle Demo Updated");
        log.info("[MANAGED]    name changed on managed entity, dirty-checking will pick this up: name='{}'", customer.getName());

        entityManager.flush();
        log.info("[MANAGED]    flush() executed, update SQL sent to DB");

        // DETACHED: no longer tracked by the persistence context; changes are ignored.
        Customer detachedCustomer = customer;
        entityManager.detach(detachedCustomer);
        log.info("[DETACHED]   detach() called, managed={}", entityManager.contains(detachedCustomer));

        detachedCustomer.setName("Detached value should not persist");
        log.info("[DETACHED]   name changed while detached, this update is lost: name='{}'", detachedCustomer.getName());

        // MANAGED (again): merge() copies detached state onto a (re)managed instance.
        Customer merged = entityManager.merge(detachedCustomer);
        log.info("[MERGED]     merge() called, returned instance is managed={}, name='{}'", entityManager.contains(merged), merged.getName());

        // REMOVED: scheduled for deletion; removed at flush/commit time.
        entityManager.remove(merged);
        log.info("[REMOVED]    remove() called, entity scheduled for deletion, id={}", merged.getId());
    }
}
