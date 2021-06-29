package com.example.invisiblegardening.repositories;

import com.example.invisiblegardening.models.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MachineRepository extends JpaRepository<Machine, Long> {

    List<Machine> findMachinesByMachineName(String machineName);

    List<Machine> findByMachineType(String MachineType);

}
