package com.example.invisiblegardening.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class CustomerData {

    @Id
    @GeneratedValue
    Long id;

    String customersName;
    String customersAddress;
    String customersZipcode;
    String customersCity;
    String customersEmailaddress;
    String customersPhoneNumber;

    @OneToOne(mappedBy = "customerData")
    @JsonBackReference("requestCustomerData")
    Request request;

    @OneToOne
    @JsonBackReference("customerDataCompany")
    Company company;


    public Long getId() {
        return id;
    }

    public String getCustomersName() {
        return customersName;
    }

    public String getCustomersAddress() {
        return customersAddress;
    }

    public String getCustomersZipcode() {
        return customersZipcode;
    }

    public String getCustomersCity() {
        return customersCity;
    }

    public String getCustomersEmailaddress() {
        return customersEmailaddress;
    }

    public String getCustomersPhoneNumber() {
        return customersPhoneNumber;
    }

    public Request getRequest() {
        return request;
    }

    public Company getCompany() {
        return company;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomersName(String customersName) {
        this.customersName = customersName;
    }

    public void setCustomersAddress(String customersAddress) {
        this.customersAddress = customersAddress;
    }

    public void setCustomersZipcode(String customersZipcode) {
        this.customersZipcode = customersZipcode;
    }

    public void setCustomersCity(String customersCity) {
        this.customersCity = customersCity;
    }

    public void setCustomersEmailaddress(String customersEmailaddress) {
        this.customersEmailaddress = customersEmailaddress;
    }

    public void setCustomersPhoneNumber(String customersPhoneNumber) {
        this.customersPhoneNumber = customersPhoneNumber;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

