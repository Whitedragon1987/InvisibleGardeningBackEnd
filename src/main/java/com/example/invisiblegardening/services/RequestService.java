package com.example.invisiblegardening.services;

import com.example.invisiblegardening.models.Request;

import java.time.LocalDateTime;
import java.util.List;

public interface RequestService {
    List<Request> getRequestsBetweenDates(LocalDateTime start, LocalDateTime end);

    List<Request> getRequestsForMachines(Long machineId);

    List<Request> getRequestsForCustomerRequest(Long customerRequestId);

    List<Request> getRequestsForJob(Long jobId);

    void assignMachineToRequest(Long machineId, Long requestId);

    void assignCustomerRequestToRequest(Long customerRequestId, Long requestId);

    void assignJobToRequest(Long jobId, Long requestId);

    void assignCustomerDataToRequest(Long customerDataId, Long requestId);

    void planRequest(Long customerRequestId, Long machineId, Long jobId, LocalDateTime plannedStartTime, LocalDateTime plannedEndTime);

    Request completeRequest(Long requestId, LocalDateTime actualStartTime, LocalDateTime actualEndTime);
}
