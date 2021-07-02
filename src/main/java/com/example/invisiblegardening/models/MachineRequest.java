//package com.example.invisiblegardening.models;
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
//    @OneToMany(mappedBy = "machineRequest")
//    List<Machine> machineList;
//
//    @OneToMany(mappedBy = "machineRequest")
//    List<CustomerRequest> customerRequest;
//
//    public Long getId() {
//        return id;
//    }
//
//    public List<Machine> getMachineList() {
//        return machineList;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setCustomerRequest(List<CustomerRequest> customerRequest) {
//        this.customerRequest = customerRequest;
//    }
//}
