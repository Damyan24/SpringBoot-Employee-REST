package com.cruddemo.employeesCrud.service;

import com.cruddemo.employeesCrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee emp);

    void delete(Integer id);
}
