package com.example.invisiblegardening.controllers;

import com.example.invisiblegardening.controllers.dto.*;
import com.example.invisiblegardening.models.CustomerData;
import com.example.invisiblegardening.services.CustomerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("klantdata")
public class CustomerDataController {
    private final CustomerDataService customerDataService;

    @Autowired
    public CustomerDataController(CustomerDataService customerDataService) {
        this.customerDataService = customerDataService;
    }

    @GetMapping
    public List<CustomerDataDto> getCustomerDatas() {
        var dtos = new ArrayList<CustomerDataDto>();
        var customerDatas = customerDataService.getCustomerDatas();

        for (CustomerData customerData : customerDatas) {
            dtos.add(CustomerDataDto.fromCustomerData(customerData));
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public CustomerDataDto getCustomerData(@PathVariable("id") Long id) {
        var customerData = customerDataService.getCustomerData(id);
        return CustomerDataDto.fromCustomerData(customerData);
    }

    @PostMapping
    public CustomerDataDto saveCustomerData(@RequestBody CustomerDataInputDto dto) {
        var customerData = customerDataService.saveCustomerData(dto.toCustomerData());
        return CustomerDataDto.fromCustomerData(customerData);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerData(@PathVariable("id") Long id) {
        customerDataService.deleteCustomerData(id);
    }

    @PutMapping("/{id}")
    public CustomerDataDto updateCustomerData(@PathVariable Long id, @RequestBody CustomerData customerData) {
        customerDataService.updateCustomerData(id, customerData);
        return CustomerDataDto.fromCustomerData(customerData);
    }

    @PostMapping("/{id}/bedrijf")
    public void assignCompanyToCustomerData(@PathVariable("id") Long customerDataId,@RequestBody IdInputDto input) {
        customerDataService.assignCompanyToCustomerData(customerDataId, input.id);
    }
}