package com.example.invisiblegardening.repositories;

import com.example.invisiblegardening.models.CustomerRequest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRequestRepository extends JpaRepository<CustomerRequest, Long> {
}
