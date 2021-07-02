package com.example.invisiblegardening.controllers;

import com.example.invisiblegardening.controllers.dto.CustomerRequestDto;
import com.example.invisiblegardening.controllers.dto.CustomerRequestInputDto;
import com.example.invisiblegardening.controllers.dto.MachineDto;
import com.example.invisiblegardening.exeptions.BadRequestException;
import com.example.invisiblegardening.models.CustomerData;
import com.example.invisiblegardening.models.CustomerRequest;
import com.example.invisiblegardening.models.Machine;
import com.example.invisiblegardening.services.CustomerRequestService;
import com.example.invisiblegardening.services.MachineService;
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
    private final MachineService machineService;

    @Autowired
    public CustomerRequestController(CustomerRequestService customerRequestService,
                                     MachineService machineService){
        this.customerRequestService = customerRequestService;
        this.machineService = machineService;
    }

    @GetMapping
    public List<CustomerRequestDto> getCustomerRequests(@RequestParam(value = "machineList", required = false) List<Machine> machineList,
                                        @RequestParam(value = "customerData", required = false) CustomerData customerData,
                                        @RequestParam(value = "start", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                        @RequestParam(value = "end", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        var dtos = new ArrayList<CustomerRequestDto>();

        List<CustomerRequest> customerRequests ;
        if (machineList != null && customerData == null && start == null && end == null) {
            for (Machine machine : machineList) {
               var machineId = machineService.getMachine(machine.getId());

            customerRequests = customerRequestService.getCustomerRequestsForMachineId(machineId);

        } }else if (customerData != null && machineList == null && start == null && end == null) {
            customerRequests = customerRequestService.getCustomerRequestsForCustomerData(customerData);

        } else if (start != null && end != null && customerData == null && machineList == null) {
            customerRequests = customerRequestService.getCustomerRequestsBetweenDates(start, end);

        } else {
            throw new BadRequestException();
        }

        for (CustomerRequest customerRequest : customerRequests) {
            dtos.add(CustomerRequestDto.fromCustomerRequest(customerRequest));
        }

        return dtos;
    }


    @PutMapping("/{id}")
    public CustomerRequestDto updateCustomerRequest(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        customerRequestService.updateCustomerRequest(id, customerRequest);
        return CustomerRequestDto.fromCustomerRequest(customerRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerRequest(@PathVariable("id") Long id) {
        customerRequestService.deleteCustomerRequest(id);
    }

    @PostMapping
    public void saveCustomerRequest(@RequestBody CustomerRequestInputDto dto) {
        customerRequestService.planCustomerRequest(dto.machineList, dto.customerData, dto.startTime, dto.endTime);
    }
}
