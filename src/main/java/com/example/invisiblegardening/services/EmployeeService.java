package com.example.invisiblegardening.services;

import com.example.invisiblegardening.models.Employee;
import java.util.List;


public interface EmployeeService {

    List<Employee> getEmployees();
    List<Employee> findEmployeesByName(String name);

    Employee getEmployee(Long id);
    Employee saveEmployee(Employee employee);

    void deleteEmployee(Long id);
    void updateEmployee(Long id, Employee employee);

}
