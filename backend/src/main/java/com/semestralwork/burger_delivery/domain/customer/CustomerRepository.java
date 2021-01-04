package com.semestralwork.burger_delivery.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM CUSTOMER WHERE customer.email = ?1", nativeQuery = true)
    Optional<Customer> findCustomerByEmail(String email);

    @Query(value = "SELECT * FROM CUSTOMER WHERE customer_id = ?1 AND email = ?2", nativeQuery = true)
    Optional<Customer> getCustomerByPhoneAndEmail(Long id, String email);

    @Query(value = "SELECT * FROM CUSTOMER WHERE email = ?1 AND phone = ?2 AND name = ?3 AND surname = ?4", nativeQuery = true)
    Optional<Customer> findCustomerByMandatoryFieldsAndMail(String email, BigDecimal phone, String name, String surname);
}
