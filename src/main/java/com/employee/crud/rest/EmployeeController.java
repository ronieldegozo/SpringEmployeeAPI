package com.employee.crud.rest;

import com.employee.crud.dao.EmployeeDAO;
import com.employee.crud.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EmployeeController {

    public EmployeeDAO employeeDAO;

    //Inject Employee DAO over the Database
    public EmployeeController(EmployeeDAO empDAO){
        employeeDAO = empDAO;
    }

    //expose /employees over the API response
    @GetMapping("/employees")
    public List<Employee>findAll(){
        return employeeDAO.findAll();
    }

}
