package com.robinsingh.employees.dao;

import com.robinsingh.employees.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();
}
