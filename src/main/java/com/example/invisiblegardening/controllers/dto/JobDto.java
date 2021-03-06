package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.Job;

public class JobDto {
    public Long id;
    public String name;
    public String description;
    public Boolean machineNeeded;
    public Boolean employeeNeeded;

    public static JobDto fromJob(Job job) {
        var dto = new JobDto();
        dto.id = job.getId();
        dto.name = job.getJobName();
        dto.description = job.getJobDescription();
        dto.machineNeeded = job.getMachineNeeded();
        dto.employeeNeeded = job.getEmployeeNeeded();
        return dto;
    }
}
