package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.entities.Department;
import io.zipcoder.persistenceapp.services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class DepartmentController {

    @Autowired
    DepartmentServices departmentServices;

    @GetMapping("API/departments/{id}")
    public ResponseEntity<Department> getDepartment (@PathVariable Long id) {
        return new ResponseEntity<>(departmentServices.getDepartment(id), HttpStatus.OK);
    }

    @PutMapping("API/departments/{id}")
    public ResponseEntity<Department> updateDepartment (@RequestBody Department department) {
        return new ResponseEntity<>(departmentServices.updateDept(department), HttpStatus.OK);
    }

    @PostMapping("API/departments")
    public ResponseEntity<Department> addDepartment (@RequestBody Department department) {
        return new ResponseEntity<>(departmentServices.createDept(department), HttpStatus.CREATED);
    }
    @PutMapping("API/employees/{id}/manager/{managerId)")
    public ResponseEntity<Department> setManager (@PathVariable Long id, @PathVariable Long managerId){
        Department department = departmentServices.setManager(id,managerId);
        if(department != null){
            return new ResponseEntity<>(department, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
