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
    Double machineValueOfPurchase;
    String machineStatus;
    Date machineLastService;
    Date machinePlannedService;

    @Lob
    byte[] machineImage;

    @OneToMany(mappedBy = "machine")
    List<Request> requestList;


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

    public Double getMachineValueOfPurchase() {
        return machineValueOfPurchase;
    }

    public String getMachineStatus() {
        return machineStatus;
    }

    public Date getMachineLastService() {
        return machineLastService;
    }

    public Date getMachinePlannedService() {
        return machinePlannedService;
    }

    public byte[] getMachineImage() {
        return machineImage;
    }

    public List<Request> getRequestList() {
        return requestList;
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

    public void setMachineValueOfPurchase(Double machineValueOfPurchase) {
        this.machineValueOfPurchase = machineValueOfPurchase;
    }

    public void setMachineStatus(String machineStatus) {
        this.machineStatus = machineStatus;
    }

    public void setMachineLastService(Date machineLastService) {
        this.machineLastService = machineLastService;
    }

    public void setMachinePlannedService(Date machinePlannedService) {
        this.machinePlannedService = machinePlannedService;
    }

    public void setMachineImage(byte[] machineImage) {
        this.machineImage = machineImage;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

}
