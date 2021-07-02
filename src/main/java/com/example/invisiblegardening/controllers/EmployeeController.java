package com.example.invisiblegardening.controllers;

import com.example.invisiblegardening.controllers.dto.EmployeeDto;
import com.example.invisiblegardening.controllers.dto.EmployeeInputDto;
import com.example.invisiblegardening.controllers.dto.IdInputDto;
import com.example.invisiblegardening.controllers.dto.MachineDto;
import com.example.invisiblegardening.models.Employee;
import com.example.invisiblegardening.models.Machine;
import com.example.invisiblegardening.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("werknemers")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {this.employeeService = employeeService;}

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable("id") Long id) {
        var employee = employeeService.getEmployee(id);
        return EmployeeDto.fromEmployee(employee);
    }

    @GetMapping
    public List<EmployeeDto> getEmployees() {
        var dtos = new ArrayList<EmployeeDto>();
        var employees = employeeService.getEmployees();

        for (Employee employee : employees) {
            dtos.add(EmployeeDto.fromEmployee(employee));
        }
        return dtos;
    }

    @GetMapping("/{name}")
    public List<EmployeeDto> findEmployeesByName(@RequestParam(value = "name", required = true, defaultValue = "") String name) {
        var dtos = new ArrayList<EmployeeDto>();
        var employees = employeeService.findEmployeesByName(name);

        if ( name != null) {
            employees = employeeService.findEmployeesByName(name);
        }
        for (Employee employee : employees) {
            dtos.add(EmployeeDto.fromEmployee(employee));
        }
        return dtos;
    }

    @PostMapping
    public EmployeeDto saveEmployee(@RequestBody EmployeeInputDto dto) {
        var employee = employeeService.saveEmployee(dto.toEmployee());
        return EmployeeDto.fromEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
        return EmployeeDto.fromEmployee(employee);
    }
}
