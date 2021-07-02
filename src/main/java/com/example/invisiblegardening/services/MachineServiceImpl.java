package com.example.invisiblegardening.services;

import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.models.Machine;
import com.example.invisiblegardening.repositories.MachineRepository;
import com.example.invisiblegardening.repositories.MachineRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineServiceImpl implements MachineService{
    private MachineRepository machineRepository;
    private MachineRequestRepository machineRequestRepository;

    @Autowired
    public MachineServiceImpl(MachineRepository machineRepository,
                              MachineRequestRepository machineRequestRepository) {
        this.machineRepository = machineRepository;
        this.machineRequestRepository = machineRequestRepository;
    }

//  vind een machine op basis van een id en geef deze terug, als de machine niet gevonden word geef een record not found exception
    @Override
    public Machine getMachine(Long id) {
        Optional<Machine> machine = machineRepository.findById(id);

        if(machine.isPresent()) {
            return machine.get();
        } else {
            throw new RecordNotFoundException("Machine does not exist");
        }
    }

//  vind alle machines en geef deze in een lijst terug
    @Override
    public List<Machine> getMachines() {
        return machineRepository.findAll();
    }

//    @Override
//    public byte[] getMachineImage(Long id) {
//        var optionalMachine = machineRepository.findById(id);
//        if (optionalMachine.isPresent()) {
//            return optionalMachine.get().getMachineImage();
//        } else {
//            throw new RecordNotFoundException();
//        }
//    }

//    @Override
//    public List<Machine> findMachinesByMachineName(String name) {
//        return machineRepository.findMachinesByMachineName(name);
//    }

//  vind alle machines van een type in een lijst
//    @Override
//    public List<Machine> findMachinesByMachineType(String type) {
//        return machineRepository.findByMachineType(type);
//    }

//  sla een nieuwe machine op
    @Override
    public Machine saveMachine(Machine machine) {
        return machineRepository.save(machine);
    }

//  wijzig een bestaande machine op basis van id, als id niet gevonden word geef record not found exception
    @Override
    public void updateMachine(Long id, Machine machine) {
        Optional<Machine> optionalMachine = machineRepository.findById(id);
        if(optionalMachine.isPresent()) {
            machineRepository.save(machine);
        } else {
            throw new RecordNotFoundException("Machine does not exist");
        }
    }

//  verwijder een bestaande machine op basis van id
    @Override
    public void deleteMachine(Long id) {
        machineRepository.deleteById(id);
    }

//    @Override
//    public void uploadMachineImage(Long id, MultipartFile file) throws IOException {
//        var optionalMachine = machineRepository.findById(id);
//        if (optionalMachine.isPresent()) {
//            var machine = optionalMachine.get();
//            machine.setMachineImage(file.getBytes());
//            machineRepository.save(machine);
//        } else {
//            throw new RecordNotFoundException();
//        }
//    }


}
