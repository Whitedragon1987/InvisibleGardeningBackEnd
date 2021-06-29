package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.Job;
import com.example.invisiblegardening.models.Machine;

import java.util.List;

public class JobInputDto {
    public Long id;
    public String name;
    public String description;
    public Boolean machineNeeded;
    public Boolean employeeNeeded;
    public List<Machine> machine;

    public Job toJob() {
        var job = new Job();
        job.setId(id);
        job.setJobName(name);
        job.setJobDescription(description);
        job.setMachineNeeded(machineNeeded);
        job.setEmployeeNeeded(employeeNeeded);
    return job;
    }
}
