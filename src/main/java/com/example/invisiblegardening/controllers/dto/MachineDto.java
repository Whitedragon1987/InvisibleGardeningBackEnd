package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.Job;
import com.example.invisiblegardening.models.Machine;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class MachineDto {
    public Long id;
    public String name;
    public String description;
    public String type;
    public String measurements;
    public Double valueOfPurchase;
    public String status;
    public Date lastService;
    public Date plannedService;



    public static MachineDto fromMachine(Machine machine) {
        var dto = new MachineDto();
        dto.id = machine.getId();
        dto.name = machine.getMachineName();
        dto.description = machine.getMachineDescription();
        dto.type = machine.getMachineType();
        dto.measurements = machine.getMachineMeasurements();
        dto.valueOfPurchase = machine.getMachineValueOfPurchase();
        dto.status = machine.getMachineStatus();
        dto.lastService = machine.getMachineLastService();
        dto.plannedService = machine.getMachinePlannedService();

        return dto;
    }
}
