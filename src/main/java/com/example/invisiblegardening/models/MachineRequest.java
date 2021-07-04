//package com.example.invisiblegardening.models;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//public class MachineRequest {
//
//    @Id
//    @GeneratedValue
//    Long id;
//
//    @OneToOne
//    @JsonBackReference("machineRequestCustomerRequest")
//    CustomerRequest customerRequest;
//
//    @OneToMany(mappedBy = "machineRequest")
//    List<Machine> machines;
//
//    public Long getId() {
//        return id;
//    }
//
//    public CustomerRequest getCustomerRequest() {
//        return customerRequest;
//    }
//
//    public List<Machine> getMachines() {
//        return machines;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setCustomerRequest(CustomerRequest customerRequest) {
//        this.customerRequest = customerRequest;
//    }
//
//    public void setMachines(List<Machine> machines) {
//        this.machines = machines;
//    }
//}
