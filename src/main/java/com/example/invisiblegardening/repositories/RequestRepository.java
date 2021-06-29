package com.example.invisiblegardening.repositories;

import com.example.invisiblegardening.models.CustomerRequest;
import com.example.invisiblegardening.models.Job;
import com.example.invisiblegardening.models.Machine;
import com.example.invisiblegardening.models.Request;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long>{

    List<Request> findByPlannedStartTimeBetween(LocalDateTime start, LocalDateTime end);

    List<Request> findByMachine(Machine machine);

    List<Request> findByCustomerRequest(CustomerRequest customerRequest);

    List<Request> findByJob(Job job);

    List<Request> findByPlannedStartTimeBetweenAndMachineAndJob(LocalDateTime startTime, LocalDateTime endTime, Machine machine, Job job);

    List<Request> findByPlannedEndTimeBetweenAndMachineAndJob(LocalDateTime startTime, LocalDateTime endTime, Machine machine, Job job);
}
