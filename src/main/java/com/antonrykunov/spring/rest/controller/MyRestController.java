package com.antonrykunov.spring.rest.controller;

import com.antonrykunov.spring.rest.entity.Employee;
import com.antonrykunov.spring.rest.exeption_heanding.EmployeeIncorectData;
import com.antonrykunov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public String showAllEmployees() {
//        List<Employee> allEmployees = employeeService.getAllEmployees();
        return "allEmployees";
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            try {
                throw new NoSuchFieldException("Рабочего с id = " + id + "нет в базе");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployees(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if(employee == null) {
            try {
                throw new NoSuchFieldException("No employee with " + id + " in database");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

        employeeService.deleteEmployee(id);

        return "Employee with " + id + " wos deleted";
    }
}

