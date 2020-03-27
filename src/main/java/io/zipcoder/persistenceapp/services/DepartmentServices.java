package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.entities.Department;
import io.zipcoder.persistenceapp.entities.Employee;
import io.zipcoder.persistenceapp.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServices {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeServices employeeService;



    public Department getDepartment(Long id){
        return departmentRepository.findOne(id);
    }

    public Department createDept(Department department){
        return departmentRepository.save(department);
    }

    public Department updateDept(Department department){
        return departmentRepository.save(department);
    }

    public Department setManager(Long id, Long managerId){
        Department department = getDepartment(id);
        Employee manager = employeeService.getEmployee(managerId);
        if(department != null && manager != null){
            department.setManager(manager);
            return departmentRepository.save(department);
        }else {
            return  null;
        }

    }
}
