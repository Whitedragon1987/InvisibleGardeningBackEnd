package com.example.invisiblegardening.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue
    Long id;

    String jobName;
    String jobDescription;
    Boolean employeeNeeded;

    @ManyToOne
    @JsonBackReference("jobEmployee")
    Employee employee;

    @OneToMany(mappedBy = "job")
    List<CustomerRequest> customerRequests;

    public Long getId() {
        return id;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public Boolean getEmployeeNeeded() {
        return employeeNeeded;
    }

    public Employee getEmployee() {
        return employee;
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

    public void setEmployeeNeeded(Boolean employeeNeeded) {
        this.employeeNeeded = employeeNeeded;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
