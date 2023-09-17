package com.cruddemo.employeesCrud.controller;

import com.cruddemo.employeesCrud.entity.Employee;
import com.cruddemo.employeesCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee emp = employeeService.findById(employeeId);
        if(emp == null){
            throw new RuntimeException("No employee with id: " + employeeId);
        }
        return emp;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee emp){
        emp.setId(0);
        return employeeService.save(emp);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee emp){

        return employeeService.save(emp);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String delete(@PathVariable int employeeId){
        Employee emp = employeeService.findById(employeeId);

        if(emp == null){
            throw new RuntimeException("Employee with id: " + employeeId +" not found");
        }
        employeeService.delete(employeeId);
        return "Employee with id:"+employeeId + " is deleted !!!!";
    }
}
