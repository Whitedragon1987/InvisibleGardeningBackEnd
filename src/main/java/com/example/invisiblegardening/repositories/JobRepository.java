package com.example.invisiblegardening.repositories;

import com.example.invisiblegardening.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
