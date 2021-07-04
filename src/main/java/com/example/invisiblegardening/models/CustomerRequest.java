package com.example.invisiblegardening.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
    LocalDateTime confirmedStartTime;
    LocalDateTime getConfirmedEndTime;
    RequestStatus status;

    @ManyToOne
    CustomerData customerData;

    @ManyToMany
    List<Machine> machines;

    public Long getId() {
        return id;
    }

    public LocalDateTime getRequestedStartTime() {
        return requestedStartTime;
    }

    public LocalDateTime getRequestedEndTime() {
        return requestedEndTime;
    }

    public CustomerData getCustomerData() {
        return customerData;
    }

    public LocalDateTime getConfirmedStartTime() {
        return confirmedStartTime;
    }

    public LocalDateTime getGetConfirmedEndTime() {
        return getConfirmedEndTime;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public List<Machine> getMachines() {
        return machines;
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

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }

    public void setConfirmedStartTime(LocalDateTime confirmedStartTime) {
        this.confirmedStartTime = confirmedStartTime;
    }

    public void setGetConfirmedEndTime(LocalDateTime getConfirmedEndTime) {
        this.getConfirmedEndTime = getConfirmedEndTime;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }
}
