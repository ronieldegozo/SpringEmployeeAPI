package com.employee.crud.rest;

import com.employee.crud.exception.NotFoundException;
import com.employee.crud.model.Employee;
import com.employee.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeesService;

    //Inject Employee DAO over the Database
    @Autowired
    public EmployeeController(EmployeeService empService){
        employeesService = empService;
    }

    //expose /employees over the API response
    @GetMapping("/employees")
    public List<Employee>findAll(){
        return employeesService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee getEmpId = employeesService.findById(employeeId);

        if(getEmpId == null){
            throw new NotFoundException("Employee ID not found! " + employeeId);
        }

        return getEmpId;

    }
}
