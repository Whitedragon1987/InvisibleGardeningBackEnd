package com.example.invisiblegardening.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Machine {

    @Id
    @GeneratedValue
    Long id;

    String machineName;
    String machineDescription;
    String machineType;
    String machineMeasurements;
    Date machineLastService;
    Date machinePlannedService;

    @OneToMany(mappedBy = "machine")
    List<CustomerRequest> customerRequests;


    public Long getId() {
        return id;
    }

    public String getMachineName() {
        return machineName;
    }

    public String getMachineDescription() {
        return machineDescription;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getMachineMeasurements() {
        return machineMeasurements;
    }

    public Date getMachineLastService() {
        return machineLastService;
    }

    public Date getMachinePlannedService() {
        return machinePlannedService;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public void setMachineDescription(String machineDescription) {
        this.machineDescription = machineDescription;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public void setMachineMeasurements(String machineMeasurements) {
        this.machineMeasurements = machineMeasurements;
    }

    public void setMachineLastService(Date machineLastService) {
        this.machineLastService = machineLastService;
    }

    public void setMachinePlannedService(Date machinePlannedService) {
        this.machinePlannedService = machinePlannedService;
    }

}
