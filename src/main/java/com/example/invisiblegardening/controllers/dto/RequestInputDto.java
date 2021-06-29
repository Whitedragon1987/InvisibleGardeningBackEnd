package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.Request;

import java.time.LocalDateTime;

public class RequestInputDto {

    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public Long customerRequestId;
    public Long machineId;
    public Long jobId;

    public Request toRequest() {
        var request = new Request();
        request.setPlannedStartTime(startTime);
        request.setPlannedEndTime(endTime);
        return request;
    }
}
