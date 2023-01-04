package com.springapiapp.api.service;

import com.springapiapp.api.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee getEmployeeById(Long id);
}
