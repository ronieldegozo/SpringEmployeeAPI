package com.employee.crud.service;

import com.employee.crud.model.Employee;
import java.util.List;

public interface EmployeeService {

    //Return DAO Data Model
    List<Employee> findAll();

}
