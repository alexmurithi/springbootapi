package com.springapiapp.api.controller;

import com.springapiapp.api.model.Employee;
import com.springapiapp.api.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
    @PutMapping(path = "{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable long id){
        return ResponseEntity.ok(employeeService.updateEmployee(employee,id));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Operation Successful!",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
