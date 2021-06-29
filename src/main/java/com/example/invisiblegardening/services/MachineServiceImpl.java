package com.example.invisiblegardening.services;

import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.models.Machine;
import com.example.invisiblegardening.repositories.JobRepository;
import com.example.invisiblegardening.repositories.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MachineServiceImpl implements MachineService{
    private MachineRepository machineRepository;

    @Autowired
    public MachineServiceImpl(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Override
    public Machine getMachine(Long id) {
        Optional<Machine> machine = machineRepository.findById(id);

        if(machine.isPresent()) {
            return machine.get();
        } else {
            throw new RecordNotFoundException("Machine does not exist");
        }
    }

    @Override
    public List<Machine> getMachines() {
        return machineRepository.findAll();
    }

    @Override
    public byte[] getMachineImage(Long id) {
        var optionalMachine = machineRepository.findById(id);
        if (optionalMachine.isPresent()) {
            return optionalMachine.get().getMachineImage();
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public List<Machine> findMachinesByMachineName(String name) {
        return machineRepository.findMachinesByMachineName(name);
    }

    @Override
    public List<Machine> findMachinesByMachineType(String type) {
        return machineRepository.findByMachineType(type);
    }

    @Override
    public Machine saveMachine(Machine machine) {
        return machineRepository.save(machine);
    }

    @Override
    public void updateMachine(Long id, Machine machine) {
        Optional<Machine> optionalMachine = machineRepository.findById(id);
        if(optionalMachine.isPresent()) {
            machineRepository.save(machine);
        } else {
            throw new RecordNotFoundException("Machine does not exist");
        }
    }

    @Override
    public void deleteMachine(Long id) {
        machineRepository.deleteById(id);
    }

    @Override
    public void uploadMachineImage(Long id, MultipartFile file) throws IOException {
        var optionalMachine = machineRepository.findById(id);
        if (optionalMachine.isPresent()) {
            var machine = optionalMachine.get();
            machine.setMachineImage(file.getBytes());
            machineRepository.save(machine);
        } else {
            throw new RecordNotFoundException();
        }
    }
}
