package com.example.invisiblegardening.models;

import com.example.invisiblegardening.controllers.MachineController;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Request {

    @Id
    @GeneratedValue
    Long id;

    LocalDateTime plannedStartTime;
    LocalDateTime plannedEndTime;
    LocalDateTime actualStartTime;
    LocalDateTime actualEndTime;
    RequestStatus status;

    @ManyToOne
    Machine machine;

    @ManyToOne
    CustomerRequest customerRequest;

    @ManyToOne
    Job job;

    @OneToOne
    @JsonBackReference("requestCustomerData")
    CustomerData customerData;

    public Long getId() {
        return id;
    }

    public Machine getMachine() {
        return machine;
    }

    public CustomerRequest getCustomerRequest() {
        return customerRequest;
    }

    public Job getJob() {
        return job;
    }

    public LocalDateTime getPlannedStartTime() {
        return plannedStartTime;
    }

    public LocalDateTime getPlannedEndTime() {
        return plannedEndTime;
    }

    public LocalDateTime getActualStartTime() {
        return actualStartTime;
    }

    public LocalDateTime getActualEndTime() {
        return actualEndTime;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public CustomerData getCustomerData() {
        return customerData;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public void setCustomerRequest(CustomerRequest customerRequest) {
        this.customerRequest = customerRequest;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setPlannedStartTime(LocalDateTime plannedStartDate) {
        this.plannedStartTime = plannedStartDate;
    }

    public void setPlannedEndTime(LocalDateTime plannedEndDate) {
        this.plannedEndTime = plannedEndDate;
    }

    public void setActualStartTime(LocalDateTime actualStartDate) {
        this.actualStartTime = actualStartDate;
    }

    public void setActualEndTime(LocalDateTime actualEndDate) {
        this.actualEndTime = actualEndDate;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }
}
