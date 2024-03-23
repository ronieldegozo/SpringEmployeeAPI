package com.employee.crud.dao;

import com.employee.crud.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    //Return DAO Data Model
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

}
