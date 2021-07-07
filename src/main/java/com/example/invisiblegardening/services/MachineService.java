package com.example.invisiblegardening.services;

import com.example.invisiblegardening.models.Machine;
import java.util.List;

public interface MachineService {

    List<Machine> getMachines();

    Machine getMachine(Long id);
    Machine saveMachine(Machine machine);

    void updateMachine(Long id, Machine machine);
    void deleteMachine(Long id);


}
