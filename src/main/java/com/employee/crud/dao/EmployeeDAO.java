package com.employee.crud.dao;

import com.employee.crud.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    //Return DAO Data Model
    List<Employee> findAll();

}
