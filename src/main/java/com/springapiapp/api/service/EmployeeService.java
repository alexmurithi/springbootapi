package com.springapiapp.api.service;

import com.springapiapp.api.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getEmployees();
}
