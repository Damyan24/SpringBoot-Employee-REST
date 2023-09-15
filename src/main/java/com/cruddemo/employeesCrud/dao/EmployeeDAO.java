package com.cruddemo.employeesCrud.dao;

import com.cruddemo.employeesCrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee emp);

    void delete(Integer id);


}
