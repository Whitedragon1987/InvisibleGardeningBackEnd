package com.example.invisiblegardening.repositories;

import com.example.invisiblegardening.models.CustomerData;
import com.example.invisiblegardening.models.CustomerRequest;
import com.example.invisiblegardening.models.Machine;
//import com.example.invisiblegardening.models.MachineRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface CustomerRequestRepository extends JpaRepository<CustomerRequest, Long> {

    List<CustomerRequest> findByCustomerData(CustomerData customerData);

    List<CustomerRequest> findByRequestedStartTimeBetween(LocalDateTime start, LocalDateTime end);

}
