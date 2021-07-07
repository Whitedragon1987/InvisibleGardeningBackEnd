package com.example.invisiblegardening.services;

import com.example.invisiblegardening.models.*;

import java.time.LocalDateTime;
import java.util.List;


public interface CustomerRequestService {
    List<CustomerRequest> getCustomerRequestBetweenDates(LocalDateTime start, LocalDateTime end);
    List<CustomerRequest> getCustomerRequestsForMachine(Long machineId);
    List<CustomerRequest> getCustomerRequestsForJob(Long jobId);
    List<CustomerRequest> getCustomerRequestsForCustomerData(Long customerDataId);

    void planCustomerRequest(Long machineId, Long jobId, Long customerDataId, LocalDateTime plannedStartTime, LocalDateTime plannedEndTime);

    CustomerRequest completeCustomerRequest(Long customerRequestId, LocalDateTime actualStartTime, LocalDateTime actualEndTime);
    CustomerRequest cancelCustomerRequest(Long customerRequestId);
}
