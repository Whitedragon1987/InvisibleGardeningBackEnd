package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.Job;

public class JobDto {
    public Long id;
    public String name;
    public String description;
    public Boolean employeeNeeded;
    public EmployeeDto employee;


    public static JobDto fromJob(Job job) {
        var dto = new JobDto();
        dto.id = job.getId();
        dto.name = job.getJobName();
        dto.description = job.getJobDescription();
        dto.employeeNeeded = job.getEmployeeNeeded();
        dto.employee = EmployeeDto.fromEmployee(job.getEmployee());
        return dto;
    }
}
