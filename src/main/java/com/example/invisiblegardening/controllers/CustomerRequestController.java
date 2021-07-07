package com.example.invisiblegardening.controllers;

import com.example.invisiblegardening.controllers.dto.CustomerRequestDto;
import com.example.invisiblegardening.controllers.dto.CustomerRequestInputDto;
import com.example.invisiblegardening.exeptions.BadRequestException;
import com.example.invisiblegardening.models.CustomerRequest;
import com.example.invisiblegardening.services.CustomerRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("klant-aanvragen")
public class CustomerRequestController {
    private final CustomerRequestService customerRequestService;

    @Autowired
    public CustomerRequestController(CustomerRequestService customerRequestService) {
        this.customerRequestService = customerRequestService;
    }

    @GetMapping
    public List<CustomerRequestDto> getBookings(@RequestParam(value = "machineId", required = false) Long machineId,
                                                @RequestParam(value = "jobId", required = false) Long jobId,
                                                @RequestParam(value = "customerDataId", required = false) Long customerDataId,
                                                @RequestParam(value = "start", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                                @RequestParam(value = "end", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        var dtos = new ArrayList<CustomerRequestDto>();

        List<CustomerRequest> customerRequests;
        if (machineId != null && jobId == null && customerDataId == null && start == null && end == null) {
            customerRequests = customerRequestService.getCustomerRequestsForMachine(machineId);

        } else if (jobId != null && customerDataId == null && machineId == null && start == null && end == null) {
            customerRequests = customerRequestService.getCustomerRequestsForJob(jobId);
        } else if (customerDataId != null && jobId == null && machineId == null && start == null && end == null) {
            customerRequests = customerRequestService.getCustomerRequestsForCustomerData(customerDataId);

        } else if (start != null && end != null && customerDataId == null && jobId == null && machineId == null) {
            customerRequests = customerRequestService.getCustomerRequestBetweenDates(start, end);

        } else {
            throw new BadRequestException();
        }

        for (CustomerRequest customerRequest : customerRequests) {
            dtos.add(CustomerRequestDto.fromCustomerRequest(customerRequest));
        }

        return dtos;
    }

    @PostMapping
    public void saveBooking(@RequestBody CustomerRequestInputDto dto) {
        customerRequestService.planCustomerRequest(dto.machineId, dto.jobId, dto.customerDataId, dto.startTime, dto.endTime);
    }
}