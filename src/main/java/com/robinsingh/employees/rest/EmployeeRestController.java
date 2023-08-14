package com.robinsingh.employees.rest;

import com.robinsingh.employees.dao.EmployeeDao;
import com.robinsingh.employees.entity.Employee;
import com.robinsingh.employees.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null)
            throw new RuntimeException("Employee ID:" + employeeId + " not found");

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee theEmployee) {

        theEmployee.setId(0); // in case user passes an id in request body

        return employeeService.save(theEmployee);
    }
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.findById(theEmployee.getId());
        if(dbEmployee == null)
            throw new RuntimeException("Employee Id:" + theEmployee.getId() + " is not an existing employee");

        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee dbEmployee = employeeService.findById(employeeId);
        if(dbEmployee == null)
            throw new RuntimeException("No such employee with Id: " + employeeId);

        employeeService.deleteById(employeeId);
        return "Deleted employee ID: "+employeeId;
    }

}
