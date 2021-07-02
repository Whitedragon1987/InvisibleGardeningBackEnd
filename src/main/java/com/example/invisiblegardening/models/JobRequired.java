//package com.example.invisiblegardening.models;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//public class JobRequired {
//
//    @Id
//    @GeneratedValue
//    Long id;
//
//    @ManyToOne
//    Job job;
//
//    @OneToMany(mappedBy = "jobRequired")
//    List<Machine> machineList;
//
//    public Long getId() {
//        return id;
//    }
//
////    public Job getJob() {
////        return job;
////    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
////    public void setJob(Job job) {
////        this.job = job;
////    }
//
//}
