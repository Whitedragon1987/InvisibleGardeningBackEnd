package com.example.invisiblegardening.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class JobRequired {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    Job job;

    @OneToMany
    List<Machine> machineList;

    @OneToMany
    List<Employee> employeeList;



    public Long getId() {
        return id;
    }

    public Job getJob() {
        return job;
    }

    public List<Machine> getMachineList() {
        return machineList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setMachineList(List<Machine> machineList) {
        this.machineList = machineList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
