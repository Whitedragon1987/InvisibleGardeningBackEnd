package com.example.invisiblegardening.services;


import com.example.invisiblegardening.models.Machine;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MachineService {

    Machine getMachine(Long id);

    List<Machine> getMachines();

    byte[] getMachineImage(Long id);

    List<Machine> findMachinesByMachineName(String name);

    List<Machine> findMachinesByMachineType(String type);

    Machine saveMachine(Machine machine);

    void updateMachine(Long id, Machine machine);

    void deleteMachine(Long id);

    void uploadMachineImage(Long id, MultipartFile file) throws IOException;

}
