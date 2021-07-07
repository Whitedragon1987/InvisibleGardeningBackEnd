package com.example.invisiblegardening.repositories;

import com.example.invisiblegardening.models.CustomerData;
import com.example.invisiblegardening.models.CustomerRequest;
import com.example.invisiblegardening.models.Job;
import com.example.invisiblegardening.models.Machine;
//import com.example.invisiblegardening.models.MachineRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface CustomerRequestRepository extends JpaRepository<CustomerRequest, Long> {

    List<CustomerRequest> findByRequestedStartTimeBetween(LocalDateTime start, LocalDateTime end);

    List<CustomerRequest> findByMachine(Machine machine);

    List<CustomerRequest> findByJob(Job job);

    List<CustomerRequest> findByCustomerData(CustomerData customerData);

    List<CustomerRequest> findByRequestedEndTimeBetweenAndMachine(LocalDateTime startTime, LocalDateTime endTime, Machine machine);

    List<CustomerRequest> findByRequestedStartTimeBetweenAndMachine(LocalDateTime startTime, LocalDateTime endTime, Machine machine);

    List<CustomerRequest> findByRequestedStartTimeBetweenAndJob(LocalDateTime startTime, LocalDateTime endTime, Job job);

    List<CustomerRequest> findByRequestedEndTimeBetweenAndJob(LocalDateTime startTime, LocalDateTime endTime, Job job);
}
