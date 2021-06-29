package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.CustomerRequest;

public class CustomerRequestDto {
    Long id;



    public static CustomerRequestDto fromCustomerRequest(CustomerRequest customerRequest) {
        if (customerRequest == null) return null;

        var dto = new CustomerRequestDto();
        dto.id = customerRequest.getId();
        return dto;
    }
}
