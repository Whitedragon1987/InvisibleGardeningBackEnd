package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.Machine;
import java.util.Date;

public class MachineInputDto {
    public Long id;
    public String name;
    public String description;
    public String type;
    public String measurements;
    public Date lastService;
    public Date plannedService;

    public Machine toMachine() {
        var machine = new Machine();
        machine.setId(id);
        machine.setMachineName(name);
        machine.setMachineDescription(description);
        machine.setMachineType(type);
        machine.setMachineMeasurements(measurements);
        machine.setMachineLastService(lastService);
        machine.setMachinePlannedService(plannedService);
    return machine;
    }
}
