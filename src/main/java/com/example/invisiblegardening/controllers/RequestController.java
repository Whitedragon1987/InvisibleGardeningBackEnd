package com.example.invisiblegardening.controllers;

import com.example.invisiblegardening.controllers.dto.IdInputDto;
import com.example.invisiblegardening.controllers.dto.RequestDto;
import com.example.invisiblegardening.controllers.dto.RequestInputDto;
import com.example.invisiblegardening.exeptions.BadRequestException;
import com.example.invisiblegardening.models.Request;
import com.example.invisiblegardening.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("aanvragen")
public class RequestController {
    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public List<RequestDto> getRequests(@RequestParam (value = "customerRequestId", required = true) Long customerRequestId,
                                        @RequestParam (value = "machineId", required = false) Long machineId,
                                        @RequestParam (value = "jobId", required = false) Long jobId,
                                        @RequestParam (value = "start", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime start,
                                        @RequestParam (value = "end", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        var dtos = new ArrayList<RequestDto>();

        List<Request> requests;
        if ( customerRequestId != null && machineId == null && jobId == null && start == null && end == null) {
            requests = requestService.getRequestsForCustomerRequest(customerRequestId);

        } else if ( machineId != null && customerRequestId == null && jobId == null && start == null && end == null) {
            requests = requestService.getRequestsForMachines(machineId);

        } else if ( jobId != null && machineId == null && customerRequestId == null && start == null && end == null) {
            requests = requestService.getRequestsForJob(jobId);

        } else if ( start != null && end != null&& machineId == null && jobId == null && customerRequestId == null) {
            requests = requestService.getRequestsBetweenDates(start, end);

        } else {
            throw new BadRequestException();
        }

        for (Request request : requests) {
            dtos.add(RequestDto.fromRequest(request));
        }

        return dtos;
    }

    @PostMapping("/{id}/machine")
    public void assignMachineToRequest(@PathVariable("id") Long requestId, @RequestBody IdInputDto input) {
        requestService.assignMachineToRequest(requestId, input.id);
    }

    @PostMapping("/{id}/klantaanvraag")
    public void assignCustomerRequestToRequest(@PathVariable("id") Long requestId, @RequestBody IdInputDto input) {
        requestService.assignCustomerRequestToRequest(requestId, input.id);
    }

    @PostMapping("/{id}/diensten")
    public void assignJobToRequest(@PathVariable("id") Long requestId, @RequestBody IdInputDto input) {
        requestService.assignJobToRequest(requestId, input.id);
    }

    @PostMapping("/{id}/klantgegevens")
    public void assignCustomerDataToRequest(@PathVariable("id") Long requestId,@RequestBody IdInputDto input) {
        requestService.assignCustomerDataToRequest(requestId, input.id);
    }

    @PostMapping
    public void saveRequest(@RequestBody RequestInputDto dto) {
        requestService.planRequest(dto.customerRequestId, dto.machineId, dto.jobId, dto.startTime, dto.endTime);
    }
}
