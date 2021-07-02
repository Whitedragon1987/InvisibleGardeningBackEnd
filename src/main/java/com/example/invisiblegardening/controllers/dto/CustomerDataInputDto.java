package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.CustomerData;

public class CustomerDataInputDto {
    public Long id;
    public String customersName;
    public String address;
    public String zipcode;
    public String city;
    public String emailaddress;
    public String phoneNumber;

    public CustomerData toCustomerData() {
        var customerData = new CustomerData();
        customerData.setId(id);
        customerData.setCustomersName(customersName);
        customerData.setCustomersAddress(address);
        customerData.setCustomersZipcode(zipcode);
        customerData.setCustomersCity(city);
        customerData.setCustomersEmailaddress(emailaddress);
        customerData.setCustomersPhoneNumber(phoneNumber);
        return customerData;
    }
}
