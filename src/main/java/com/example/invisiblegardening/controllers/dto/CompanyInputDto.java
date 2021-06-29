package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.Company;

public class CompanyInputDto {
    public Long id;
    public String name;
    public String address;
    public String zipcode;
    public String city;
    public String emailaddress;
    public String phoneNumber;

    public Company toCompany() {
        var company = new Company();
        company.setId(id);
        company.setCompanyName(name);
        company.setCompanyAddress(address);
        company.setCompanyZipcode(zipcode);
        company.setCompanyCity(city);
        company.setCompanyEmailaddress(emailaddress);
        company.setCompanyPhoneNumber(phoneNumber);
        return company;
    }
}
