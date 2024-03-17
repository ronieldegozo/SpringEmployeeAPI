package com.employee.crud.entity;

import com.employee.crud.dao.EmployeeDAO;
import com.employee.crud.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //Constructor injection
    @Autowired
    public EmployeeDAOJpaImp(EntityManager entityManagers){
        entityManager = entityManagers;
    }

    @Override
    public List<Employee> findAll() {

        //Create a custom query selected over the DB
        TypedQuery<Employee> getEmployees = entityManager.createQuery("from Employee", Employee.class);

        //execute the query
        List<Employee> employees = getEmployees.getResultList();

        //return the results
        return employees;
    }


}