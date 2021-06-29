package com.example.invisiblegardening.controllers;

import com.example.invisiblegardening.controllers.dto.*;
import com.example.invisiblegardening.models.CustomerRequest;
import com.example.invisiblegardening.services.CustomerRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("klant-aanvragen")
public class CustomerRequestController {
    private final CustomerRequestService customerRequestService;

    @Autowired
    public CustomerRequestController(CustomerRequestService customerRequestService){
        this.customerRequestService = customerRequestService;
    }

    @GetMapping("/{id}")
    public CustomerRequestDto getCustomerRequest(@PathVariable("id") Long id) {
        var customerRequest = customerRequestService.getID(id);
        return CustomerRequestDto.fromCustomerRequest(customerRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerRequest(@PathVariable("id") Long id) {
        customerRequestService.deleteCustomerRequest(id);
    }

    @PutMapping("/{id}")
    public CustomerRequestDto updateCustomerRequest(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        customerRequestService.updateCustomerRequest(id, customerRequest);
        return CustomerRequestDto.fromCustomerRequest(customerRequest);
    }

    @PostMapping
    public CustomerRequestDto saveCustomerRequest(@RequestBody CustomerRequestInputDto dto) {
        var customerRequest = customerRequestService.saveCustomerRequest(dto.toCustomerRequest());
        return CustomerRequestDto.fromCustomerRequest(customerRequest);
    }

}
