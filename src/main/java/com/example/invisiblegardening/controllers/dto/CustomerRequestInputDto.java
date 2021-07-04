package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.CustomerRequest;
import com.example.invisiblegardening.models.Machine;

import java.time.LocalDateTime;
import java.util.List;

public class CustomerRequestInputDto {
    public Long customerDataId;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public List<Machine> machines;

    public CustomerRequest toCustomerRequest() {
        var customerRequest = new CustomerRequest();
        customerRequest.setRequestedStartTime(startTime);
        customerRequest.setRequestedEndTime(endTime);
        for (Machine machine : machines) {
            customerRequest.setMachines(machines);
        }
        return customerRequest;
    }
}
