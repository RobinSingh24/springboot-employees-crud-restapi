package com.robinsingh.employees.dao;

import com.robinsingh.employees.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();
    Employee findById(int Id);
    Employee save(Employee employee);
    void deleteById(int Id);
}
