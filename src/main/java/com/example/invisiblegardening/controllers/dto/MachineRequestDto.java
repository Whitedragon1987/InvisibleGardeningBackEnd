//package com.example.invisiblegardening.controllers.dto;
//
//import com.example.invisiblegardening.models.MachineRequest;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//
//public class MachineRequestDto {
//    @JsonSerialize
//    Long id;
//
//    public CustomerRequestDto customerRequest;
//
//
//    public static MachineRequestDto fromMachineRequest(MachineRequest machineRequest) {
//        var dto = new MachineRequestDto();
//        dto.id = machineRequest.getId();
//        dto.customerRequest = CustomerRequestDto.fromCustomerRequest(machineRequest.getCustomerRequest());
//        return dto;
//    }
//}
//
