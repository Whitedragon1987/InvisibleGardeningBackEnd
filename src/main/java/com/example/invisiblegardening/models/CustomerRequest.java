package com.example.invisiblegardening.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class CustomerRequest {

    @Id
    @GeneratedValue
    Long id;

    LocalDateTime requestedStartTime;
    LocalDateTime requestedEndTime;

    @ManyToMany
    List<Machine> machineList;

    @ManyToOne
    CustomerData customerData;

    @ManyToMany
    List<Job> jobList;

    public Long getId() {
        return id;
    }

    public LocalDateTime getRequestedStartTime() {
        return requestedStartTime;
    }

    public LocalDateTime getRequestedEndTime() {
        return requestedEndTime;
    }

    public List<Machine> getMachineList() {
        return machineList;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public CustomerData getCustomerData() {
        return customerData;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRequestedStartTime(LocalDateTime requestedStartTime) {
        this.requestedStartTime = requestedStartTime;
    }

    public void setRequestedEndTime(LocalDateTime requestedEndTime) {
        this.requestedEndTime = requestedEndTime;
    }

    public void setMachineList(List<Machine> machineList) {
        this.machineList = machineList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }

}
