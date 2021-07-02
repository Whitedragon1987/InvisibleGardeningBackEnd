package com.example.invisiblegardening.services;

import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.models.Employee;
import com.example.invisiblegardening.models.Machine;
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

//  vind alle medewerkers en geef deze in een lijst terug
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

//  vind een medewerker aan de hand van een id
    @Override
    public Employee getEmployee(Long id) {
       return employeeRepository.getById(id);
    }

//  vind alle medewerkers aan de hand van een naam en geef deze in een lijst terug
    @Override
    public List<Employee> findEmployeesByName(String name) {
       return employeeRepository.findEmployeesByName(name);}

//  sla een nieuwe medewerker op
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

//  verwijder een medewerker aan de hand van een id
    @Override
    public void deleteEmployee(Long id) {
       employeeRepository.deleteById(id);
    }

//  wijzig een medewerker aan de hand van een id, als id niet bestaat geef een record not fout exception
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
