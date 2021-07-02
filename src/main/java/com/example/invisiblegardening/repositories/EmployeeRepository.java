package com.example.invisiblegardening.repositories;

import com.example.invisiblegardening.models.Employee;
import com.example.invisiblegardening.models.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
