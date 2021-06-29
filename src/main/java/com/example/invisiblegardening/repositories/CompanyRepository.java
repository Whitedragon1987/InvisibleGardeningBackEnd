package com.example.invisiblegardening.repositories;

import com.example.invisiblegardening.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
