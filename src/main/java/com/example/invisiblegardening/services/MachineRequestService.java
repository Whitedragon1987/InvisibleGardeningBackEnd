package com.example.invisiblegardening.services;

import com.example.invisiblegardening.models.Machine;
import com.example.invisiblegardening.models.MachineRequest;

import java.util.List;

public interface MachineRequestService {

    List<MachineRequest> getMachineRequests();

    MachineRequest getMachineRequest(Long id);

    MachineRequest saveMachineRequest(MachineRequest machineRequest);

    void deleteMachineRequest(Long id);

    void updateMachineRequest(Long id, MachineRequest machineRequest);
}