package com.example.invisiblegardening.controllers;

import com.example.invisiblegardening.controllers.dto.*;
import com.example.invisiblegardening.models.CustomerData;
import com.example.invisiblegardening.services.CustomerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("customer-datas")
public class CustomerDataController {
    private final CustomerDataService customerDataService;

    @Autowired
    public CustomerDataController(CustomerDataService customerDataService) {
        this.customerDataService = customerDataService;
    }

    @GetMapping
    public List<CustomerDataDto> getCustomerDatas(@RequestParam(value = "name", required = false, defaultValue = "") String customersName) {

        var dtos = new ArrayList<CustomerDataDto>();

        List<CustomerData> customerDataList;
        if (customersName == null){
            customerDataList = customerDataService.getCustomerDatas();
        }else {
            customerDataList = customerDataService.findCustomerDataListByCustomersName(customersName);
        }

        for (CustomerData customerData : customerDataList) {
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

    @PutMapping("/{id}")
    public CustomerDataDto updateCustomerData(@PathVariable Long id, @RequestBody CustomerData customerData) {
        customerDataService.updateCustomerData(id, customerData);
        return CustomerDataDto.fromCustomerData(customerData);
    }

    @PostMapping("/{id}/company" +
            "")
    public void assignCompanyToCustomerData(@PathVariable("id") Long customerDataId,@RequestBody IdInputDto input) {
        customerDataService.assignCompanyToCustomerData(customerDataId, input.id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerData(@PathVariable("id") Long id) {
        customerDataService.deleteCustomerData(id);
    }


}