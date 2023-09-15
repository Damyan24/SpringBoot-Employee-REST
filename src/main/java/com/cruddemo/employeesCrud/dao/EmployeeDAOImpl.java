package com.cruddemo.employeesCrud.dao;

import com.cruddemo.employeesCrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from employee",Employee.class);

        return theQuery.getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        Employee emp = entityManager.find(Employee.class , id);
        return emp;
    }

    @Override
    public Employee save(Employee emp) {
    Employee theEmp = entityManager.merge(emp);
    return  theEmp;
    }

    @Override
    public void delete(Integer id) {
        Employee emp = findById(id);
        entityManager.remove(emp);
    }
}
