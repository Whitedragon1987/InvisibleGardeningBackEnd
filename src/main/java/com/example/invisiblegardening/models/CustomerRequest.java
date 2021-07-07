package com.example.invisiblegardening.models;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class CustomerRequest {

    @Id
    @GeneratedValue
    Long id;

    LocalDateTime requestedStartTime;
    LocalDateTime requestedEndTime;
    LocalDateTime confirmedStartTime;
    LocalDateTime confirmedEndTime;
    RequestStatus status;

    @ManyToOne
    CustomerData customerData;

    @ManyToOne
    Machine machine;

    @ManyToOne
    Job job;


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

    public LocalDateTime getConfirmedEndTime() {
        return confirmedEndTime;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public Machine getMachine() {
        return machine;
    }

    public Job getJob() {
        return job;
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

    public void setConfirmedEndTime(LocalDateTime getConfirmedEndTime) {
        this.confirmedEndTime = getConfirmedEndTime;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
