package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.entities.Employee;
import io.zipcoder.persistenceapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee getEmployee(Long id) {
        return employeeRepository.findOne(id);
    }

    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.delete(id);
    }
    public void deleteEmployees(List<Employee> employees){
        employeeRepository.delete(employees);
    }


}
