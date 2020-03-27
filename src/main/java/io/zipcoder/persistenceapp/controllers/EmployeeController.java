package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.entities.Employee;
import io.zipcoder.persistenceapp.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;


    @GetMapping("/API/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeServices.getEmployee(id), HttpStatus.OK);
    }

    @GetMapping("/API/employees")
    public ResponseEntity<Iterable<Employee>> getAllemployees() {
        return new ResponseEntity<>(employeeServices.getAllEmployees(), HttpStatus.OK);

    }

    @PostMapping("/API/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeServices.createEmployee(employee), HttpStatus.CREATED);
    }


    @PutMapping("/API/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeServices.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/API/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        employeeServices.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
