package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.Employee;
import com.example.invisiblegardening.models.Job;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class EmployeeDto {
    public Long id;
    public String name;
    public String address;
    public String zipcode;
    public String city;
    public String emailaddress;
    public String phoneNumber;
    public String cityServiceNumber;
    public String ibanNumber;


    public static EmployeeDto fromEmployee(Employee employee) {
        var dto = new EmployeeDto();
        dto.id = employee.getId();
        dto.name = employee.getName();
        dto.address = employee.getAddress();
        dto.zipcode = employee.getZipcode();
        dto.city = employee.getCity();
        dto.emailaddress = employee.getEmailaddress();
        dto.phoneNumber = employee.getPhoneNumber();
        dto.cityServiceNumber = employee.getCityServiceNumber();
        dto.ibanNumber = employee.getIbanNumber();
        return dto;
    }
}
