package com.example.invisiblegardening.repositories;

import com.example.invisiblegardening.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
