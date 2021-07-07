package com.example.invisiblegardening.repositories;

import com.example.invisiblegardening.models.Machine;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MachineRepository extends JpaRepository<Machine, Long> {
}
