package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.CustomerData;
import com.example.invisiblegardening.models.CustomerRequest;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;

public class CustomerRequestDto {
    @JsonSerialize
    Long id;

    @JsonSerialize
    CustomerData customerData;

    @JsonSerialize
    MachineDto machine;

    @JsonSerialize
    JobDto job;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime startTime;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime endTime;

    public static CustomerRequestDto fromCustomerRequest(CustomerRequest customerRequest) {
        var dto = new CustomerRequestDto();
        dto.id = customerRequest.getId();
        dto.customerData = customerRequest.getCustomerData();
        dto.machine = MachineDto.fromMachine(customerRequest.getMachine());
        dto.job = JobDto.fromJob(customerRequest.getJob());
        dto.startTime = customerRequest.getRequestedStartTime();
        dto.endTime = customerRequest.getRequestedEndTime();
        return dto;
    }
}
