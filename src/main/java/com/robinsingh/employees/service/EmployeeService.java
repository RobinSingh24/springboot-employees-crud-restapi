package com.robinsingh.employees.service;

import com.robinsingh.employees.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int Id);
    Employee save(Employee employee);
    void deleteById(int Id);
}
