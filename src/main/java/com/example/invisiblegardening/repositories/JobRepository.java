package com.example.invisiblegardening.repositories;

import com.example.invisiblegardening.models.Job;
//import com.example.invisiblegardening.models.MachineRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
}
