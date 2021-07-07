package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.CustomerRequest;

import java.time.LocalDateTime;

public class CustomerRequestInputDto {

    public Long machineId;

    public Long jobId;

    public Long customerDataId;

    public LocalDateTime startTime;

    public LocalDateTime endTime;

    public CustomerRequest toCustomerRequest() {
        var customerRequest = new CustomerRequest();
        customerRequest.setRequestedStartTime(startTime);
        customerRequest.setRequestedEndTime(endTime);
        return customerRequest;
    }

}
