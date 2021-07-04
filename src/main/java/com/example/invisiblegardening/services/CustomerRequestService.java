package com.example.invisiblegardening.services;

import com.example.invisiblegardening.models.CustomerData;
import com.example.invisiblegardening.models.CustomerRequest;
import com.example.invisiblegardening.models.Job;
import com.example.invisiblegardening.models.Machine;

import java.time.LocalDateTime;
import java.util.List;


public interface CustomerRequestService {

      CustomerRequest getById(Long id);
      void deleteCustomerRequest(Long id);
      void updateCustomerRequest(Long id,CustomerRequest customerRequest);

      List<CustomerRequest> getCustomerRequestsForCustomerData(CustomerData customerData);

      List<CustomerRequest> getCustomerRequestsBetweenDates(LocalDateTime start, LocalDateTime end);

      void planCustomerRequest( Long customerDataId,List<Machine> machines, LocalDateTime startTime, LocalDateTime endTime);

      List<Machine> getMachines();
}
