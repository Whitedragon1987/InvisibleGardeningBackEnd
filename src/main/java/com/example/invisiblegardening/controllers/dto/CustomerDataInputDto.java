package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.Company;
import com.example.invisiblegardening.models.CustomerData;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class CustomerDataInputDto {
    public Long id;
    public String customersName;
    public String address;
    public String zipcode;
    public String city;
    public String emailaddress;
    public String phoneNumber;

    @JsonSerialize
    Company company;

    public CustomerData toCustomerData() {
        var customerData = new CustomerData();
        customerData.setId(id);
        customerData.setCustomersName(customersName);
        customerData.setCustomersAddress(address);
        customerData.setCustomersZipcode(zipcode);
        customerData.setCustomersCity(city);
        customerData.setCustomersEmailaddress(emailaddress);
        customerData.setCustomersPhoneNumber(phoneNumber);
        customerData.setCompany(company);
        return customerData;
    }
}
