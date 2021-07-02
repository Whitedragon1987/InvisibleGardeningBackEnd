//package com.example.invisiblegardening.controllers.dto;
//
//import com.example.invisiblegardening.models.MachineRequest;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//
//public class MachineRequestDto {
//    @JsonSerialize
//    Long id;
//
//    @JsonSerialize
//    CustomerRequestDto customerRequest;
//
//    @JsonSerialize
//    MachineDto machine;
//
//
//    public static MachineRequestDto fromMachineRequest(MachineRequest machineRequest) {
//        var dto = new MachineRequestDto();
//        dto.id = machineRequest.getId();
//        return dto;
//    }
//}
//
