package com.employee.crud.service;

import com.employee.crud.dao.EmployeeDAO;
import com.employee.crud.model.Employee;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{

    private EmployeeDAO employeeDAO;

    //Constructor Injection
    public EmployeeServiceImp(EmployeeDAO empDao){
        employeeDAO = empDao;
    }

    //Return employee DAO
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

}