package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.CustomerData;
import com.example.invisiblegardening.models.CustomerRequest;
import com.example.invisiblegardening.models.Job;
import com.example.invisiblegardening.models.Machine;

import java.time.LocalDateTime;
import java.util.List;

public class CustomerRequestInputDto {
    public CustomerData customerData;
    public List<Machine> machineList;
//    public List<Job> jobList;
    public LocalDateTime startTime;
    public LocalDateTime endTime;

    public CustomerRequest toCustomerRequest() {
        var customerRequest = new CustomerRequest();
        customerRequest.setCustomerData(customerData);
        customerRequest.setMachineList(machineList);
//        customerRequest.setJobList(jobList);
        return customerRequest;
    }
}
