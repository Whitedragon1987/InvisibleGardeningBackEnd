package com.example.invisiblegardening.repositories;

import com.example.invisiblegardening.models.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDataRepository extends JpaRepository<CustomerData, Long> {
}
