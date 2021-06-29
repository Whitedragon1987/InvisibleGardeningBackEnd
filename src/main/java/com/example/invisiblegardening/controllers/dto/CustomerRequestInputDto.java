package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.CustomerRequest;

public class CustomerRequestInputDto {

    public CustomerRequest toCustomerRequest() {
        var customerRequest = new CustomerRequest();
        return customerRequest;
    }
}
