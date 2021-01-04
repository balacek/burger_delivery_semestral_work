package com.semestralwork.burger_delivery.service;

import java.util.ArrayList;

import com.semestralwork.burger_delivery.controller.CustomerController;
import com.semestralwork.burger_delivery.domain.customer.Customer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JWTUserDetailsService implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(JWTUserDetailsService.class);

    @Autowired
    CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerService.getCustomer(email);
        return new User(customer.getEmail(), customer.getPassword(), new ArrayList<>());
    }
}
