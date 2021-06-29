package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.CustomerData;
import com.example.invisiblegardening.models.Request;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

public class RequestDto {
    @JsonSerialize
    Long id;

    @JsonSerialize
    CustomerRequestDto customerRequest;

    @JsonSerialize
    MachineDto machine;

    @JsonSerialize
    JobDto job;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime startTime;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime endTime;

    @JsonSerialize
    CustomerDataDto customerData;

    public static RequestDto fromRequest(Request request) {
        var dto = new RequestDto();
        dto.id = request.getId();
        dto.customerRequest = CustomerRequestDto.fromCustomerRequest(request.getCustomerRequest());
        dto.machine = MachineDto.fromMachine(request.getMachine());
        dto.job = JobDto.fromJob(request.getJob());
        dto.startTime = request.getPlannedStartTime();
        dto.endTime = request.getPlannedEndTime();
        dto.customerData = CustomerDataDto.fromCustomerData(request.getCustomerData());
        return dto;
    }
}