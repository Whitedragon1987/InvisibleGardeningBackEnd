package com.example.invisiblegardening.controllers.dto;


import com.example.invisiblegardening.models.Company;
import com.example.invisiblegardening.models.CustomerData;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class CustomerDataDto {
    public Long id;
    public String customersName;
    public String adress;
    public String zipcode;
    public String city;
    public String emailadress;
    public String phoneNumber;

    @JsonSerialize
    Company company;


    public static CustomerDataDto fromCustomerData(CustomerData customerData) {
        var dto = new CustomerDataDto();
        dto.id = customerData.getId();
        dto.customersName = customerData.getCustomersName();
        dto.adress = customerData.getCustomersAddress();
        dto.zipcode = customerData.getCustomersZipcode();
        dto.city = customerData.getCustomersCity();
        dto.emailadress = customerData.getCustomersEmailaddress();
        dto.phoneNumber = customerData.getCustomersPhoneNumber();
        dto.company = customerData.getCompany();
        return dto;
    }
}
