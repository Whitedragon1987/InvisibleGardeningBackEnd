package com.example.invisiblegardening.controllers.dto;

import com.example.invisiblegardening.models.Job;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


public class JobInputDto {
    public Long id;
    public String name;
    public String description;
    public Boolean employeeNeeded;
    public Long employeeId;

    public Job toJob() {
        var job = new Job();
        job.setId(id);
        job.setJobName(name);
        job.setJobDescription(description);
        job.setEmployeeNeeded(employeeNeeded);
    return job;
    }
}
