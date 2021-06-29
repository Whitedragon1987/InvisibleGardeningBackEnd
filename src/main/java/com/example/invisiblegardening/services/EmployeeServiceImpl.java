package com.example.invisiblegardening.services;

import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.models.Employee;
import com.example.invisiblegardening.repositories.EmployeeRepository;
import com.example.invisiblegardening.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
   private EmployeeRepository employeeRepository;


   @Autowired
   public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
       this.employeeRepository = employeeRepository;

   }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
       return employeeRepository.getById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
       employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepository.save(employee);
        } else {
            throw new RecordNotFoundException("employee does not exist");
        }
    }
}
