package com.example.invisiblegardening.models;

import javax.persistence.*;
import java.util.List;


@Entity
public class Job {

    @Id
    @GeneratedValue
    Long id;

    String jobName;
    String jobDescription;
    Boolean machineNeeded;
    Boolean employeeNeeded;

    @ManyToMany(mappedBy = "customerRequestList")
    List<Job> jobList;

    public Long getId() {
        return id;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public Boolean getMachineNeeded() {
        return machineNeeded;
    }

    public Boolean getEmployeeNeeded() {
        return employeeNeeded;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public void setMachineNeeded(Boolean machineNeeded) {
        this.machineNeeded = machineNeeded;
    }

    public void setEmployeeNeeded(Boolean employeeNeeded) {
        this.employeeNeeded = employeeNeeded;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }
}
