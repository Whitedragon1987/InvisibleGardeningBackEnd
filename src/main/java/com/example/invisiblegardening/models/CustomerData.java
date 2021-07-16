package com.example.invisiblegardening.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.List;

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

    @OneToOne
    @JsonBackReference("customerDataCompany")
    Company company;

    @OneToMany(mappedBy = "customerData")
    List<CustomerRequest> customerRequestList;

    @OneToOne
    User user;


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

    public Company getCompany() {
        return company;
    }

    public User getUser() {
        return user;
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

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

