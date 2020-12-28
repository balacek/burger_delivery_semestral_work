package com.semestralwork.burger_delivery.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM CUSTOMER WHERE customer.email = ?1", nativeQuery = true)
    Optional<Customer> findCustomerByEmail(String email);
}
