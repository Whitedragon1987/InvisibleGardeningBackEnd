package com.example.invisiblegardening.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class CustomerRequest {

    @Id
    @GeneratedValue
    Long id;

    @OneToMany(mappedBy = "customerRequest")
    List<Request> requestList;

    public Long getId() {
        return id;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }
}
