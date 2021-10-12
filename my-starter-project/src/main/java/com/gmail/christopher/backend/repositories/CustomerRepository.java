package com.gmail.christopher.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.christopher.backend.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
