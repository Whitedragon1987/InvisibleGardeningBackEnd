package com.example.invisiblegardening.controllers;

import com.example.invisiblegardening.controllers.dto.MachineDto;
import com.example.invisiblegardening.controllers.dto.MachineInputDto;
import com.example.invisiblegardening.models.Machine;
import com.example.invisiblegardening.services.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("machines")
public class MachineController {
    private final MachineService machineService;

    @Autowired
    public MachineController(MachineService machineService) {
        this.machineService = machineService;}

    @GetMapping
    public List<MachineDto> getMachines() {
        var dtos = new ArrayList<MachineDto>();
        var machines = machineService.getMachines();

        for (Machine machine : machines) {
            dtos.add(MachineDto.fromMachine(machine));
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public MachineDto getMachine(@PathVariable("id") Long id) {
        var machine = machineService.getMachine(id);
        return MachineDto.fromMachine(machine);
    }

    @PostMapping
    public MachineDto saveMachine(@RequestBody MachineInputDto dto) {
        var machine = machineService.saveMachine(dto.toMachine());
        return MachineDto.fromMachine(machine);
    }

    @PutMapping("/{id}")
    public MachineDto updateMachine(@PathVariable Long id, @RequestBody Machine machine) {
        machineService.updateMachine(id, machine);
        return MachineDto.fromMachine(machine);
    }

    @DeleteMapping("/{id}")
    public void deleteMachine(@PathVariable("id") Long id) {
        machineService.deleteMachine(id);
    }
}
