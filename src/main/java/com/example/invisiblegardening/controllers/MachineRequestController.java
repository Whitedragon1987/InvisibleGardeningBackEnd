//package com.example.invisiblegardening.controllers;
//
//import com.example.invisiblegardening.controllers.dto.*;
//import com.example.invisiblegardening.exeptions.BadRequestException;
//import com.example.invisiblegardening.models.MachineRequest;
//import com.example.invisiblegardening.services.MachineRequestService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@RestController
//@RequestMapping("machine-aanvragen")
//public class MachineRequestController {
//    private final MachineRequestService machineRequestService;
//
//    @Autowired
//    public MachineRequestController(MachineRequestService machineRequestService) {
//        this.machineRequestService = machineRequestService;
//    }
//
//    @GetMapping("/{id}")
//    public MachineRequestDto getMachineRequest(@PathVariable("id") Long id) {
//        var machineRequest = machineRequestService.getMachineRequest(id);
//        return MachineRequestDto.fromMachineRequest(machineRequest);
//    }
//
//    @PostMapping
//    public MachineRequestDto saveMachineRequest(@RequestBody MachineRequestInputDto dto) {
//        var machineRequest = machineRequestService.saveMachineRequest(dto.toMachineRequest());
//        return MachineRequestDto.fromMachineRequest(machineRequest);
//    }
//
//    @PutMapping("/{id}")
//    public MachineRequestDto updateMachineRequest(@PathVariable Long id, @RequestBody MachineRequest machineRequest) {
//        machineRequestService.updateMachineRequest(id, machineRequest);
//        return MachineRequestDto.fromMachineRequest(machineRequest);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteMachineRequest(@PathVariable("id") Long id) {
//        machineRequestService.deleteMachineRequest(id);
//    }
//
//    @PostMapping("/{id}")
//    public void assignCustomerRequestToMachineRequest(@PathVariable("id") Long machineRequestId, @RequestBody Long customerRequestId) {
//        machineRequestService.assignCustomerRequestToMachineRequest(machineRequestId, customerRequestId);
//    }
//
//}
