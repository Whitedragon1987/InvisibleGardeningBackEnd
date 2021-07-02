package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.CustomerData;
import com.example.invisiblegardening.models.CustomerRequest;
import com.example.invisiblegardening.models.Job;
import com.example.invisiblegardening.models.Machine;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.List;

public class CustomerRequestDto {
    @JsonSerialize
    Long id;

    @JsonSerialize
    List<Machine> machineList;

    @JsonSerialize
    CustomerData customerData;

    @JsonSerialize
    List<Job> jobList;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime startTime;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime endTime;

    public static CustomerRequestDto fromCustomerRequest(CustomerRequest customerRequest) {
        if (customerRequest == null) return null;

        var dto = new CustomerRequestDto();
        dto.id = customerRequest.getId();
        dto.customerData = customerRequest.getCustomerData();
        dto.machineList = customerRequest.getMachineList();
//        dto.jobList = customerRequest.getJobList();
        dto.startTime = customerRequest.getRequestedStartTime();
        dto.endTime = customerRequest.getRequestedEndTime();
        return dto;
    }
}
