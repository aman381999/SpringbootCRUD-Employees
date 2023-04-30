package com.practicespring.practiceSpringboot.controller;

import com.practicespring.practiceSpringboot.exception.ResourceNotFoundException;
import com.practicespring.practiceSpringboot.model.Employee;
import com.practicespring.practiceSpringboot.repository.EmployeeRepossitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepossitory employeeRepossitory;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepossitory.findAll();
    }

    //build create  employee  REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepossitory.save(employee);
    }

    //build get employee by ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepossitory.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with this ID does not exist:" + id));
        return ResponseEntity.ok(employee);
    }

    //build update employtee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepossitory.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist" + id));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepossitory.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    //build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepossitory.findById(id).orElseThrow(() -> new ResourceNotFoundException("Does not exist id:" + id));
        employeeRepossitory.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
