package com.cruddemo.employeesCrud.service;

import com.cruddemo.employeesCrud.dao.EmployeeDAO;
import com.cruddemo.employeesCrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee emp) {
        return employeeDAO.save(emp);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        employeeDAO.delete(id);
    }
}
