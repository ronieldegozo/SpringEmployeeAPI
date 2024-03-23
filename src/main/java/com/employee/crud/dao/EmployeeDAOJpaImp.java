package com.employee.crud.dao;

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

    @Override
    public Employee findById(int id) {

        //get employee by id
        Employee getEmpId = entityManager.find(Employee.class, id);
        //return employee
        return getEmpId;
    }

    @Override
    public Employee save(Employee employee) {

        //save employee
        Employee saveEmp = entityManager.merge(employee);
        //save employee
        return saveEmp;
    }

    @Override
    public void deleteById(int id) {

        //employee delete by id
        Employee deleteEmp = entityManager.find(Employee.class, id);
        //remove employee by id
        entityManager.remove(deleteEmp);
    }


}