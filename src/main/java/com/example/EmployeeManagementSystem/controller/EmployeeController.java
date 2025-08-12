package com.example.EmployeeManagementSystem.controller;


import com.example.EmployeeManagementSystem.dto.EmployeeDto;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> CreateEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee =employeeService.CreateEmployees(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> GetEmployeeById(@PathVariable long id) {
        EmployeeDto employeeDto =employeeService.GetEmployeeById(id);
        return  ResponseEntity.ok(employeeDto);

    }
    @GetMapping("list")
    public ResponseEntity<List<EmployeeDto>> GetAllEmployees() {
       List<EmployeeDto> employees = employeeService.GetAllEmployee();
       return ResponseEntity.ok(employees);
    }





}
