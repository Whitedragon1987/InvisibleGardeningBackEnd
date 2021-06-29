package com.example.invisiblegardening.controllers;

import com.example.invisiblegardening.controllers.dto.IdInputDto;
import com.example.invisiblegardening.controllers.dto.MachineDto;
import com.example.invisiblegardening.controllers.dto.MachineInputDto;
import com.example.invisiblegardening.exeptions.BadRequestException;
import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.models.Machine;
import com.example.invisiblegardening.services.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("machines")
public class MachineController {
    private final MachineService machineService;

    @Autowired
    public MachineController(MachineService machineService) {
        this.machineService = machineService;}

    @GetMapping("/{id}")
    public MachineDto getMachine(@PathVariable("id") Long id) {
        var machine = machineService.getMachine(id);
        return MachineDto.fromMachine(machine);
    }

    @GetMapping
    public List<MachineDto> getMachines() {
        var dtos = new ArrayList<MachineDto>();
        var machines = machineService.getMachines();

        for (Machine machine : machines) {
            dtos.add(MachineDto.fromMachine(machine));
        }
        return dtos;
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) {
        var ImageBytes = machineService.getMachineImage(id);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename").body(ImageBytes);
    }

    @GetMapping("/machines-op-naam")
    public List<MachineDto> findMachinesByMachineName(@RequestParam(value = "name", required = false, defaultValue = "") String name ){
        var dtos = new ArrayList<MachineDto>();
        var machines = machineService.findMachinesByMachineName(name);

        if (name == null) {
            machines = machineService.findMachinesByMachineName(name);
        }
        for (Machine machine : machines) {
            dtos.add(MachineDto.fromMachine(machine));
        }
        return dtos;
    }

    @GetMapping("/machines-op-type")
    public List<MachineDto> findMachinesByMachineType(@RequestParam(value = "type", required = false, defaultValue = "") String type ){
        var dtos = new ArrayList<MachineDto>();
        var machines = machineService.findMachinesByMachineType(type);

        if (type == null) {
            machines = machineService.findMachinesByMachineType(type);
        }
        for (Machine machine : machines) {
            dtos.add(MachineDto.fromMachine(machine));
        }
        return dtos;
    }

    @PostMapping
    public MachineDto saveMachine(@RequestBody MachineInputDto dto) {
        var machine = machineService.saveMachine(dto.toMachine());
        return MachineDto.fromMachine(machine);
    }

    @PostMapping("/{id}/image")
    public void uploadImage(@PathVariable("id")Long id, @RequestParam("file") MultipartFile file) {
        List<String> whitelist = new ArrayList<>();
        whitelist.add("image/gif");
        whitelist.add("image/jpeg");
        whitelist.add("image/png");
        whitelist.add("image/svg+xml");

        boolean valid = false;
        for (String s : whitelist) {
            if (file.getContentType().equals(s)) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new BadRequestException();
        }

        try {
            machineService.uploadMachineImage(id, file);
        } catch (Exception e) {
            throw new RecordNotFoundException();
        }
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
