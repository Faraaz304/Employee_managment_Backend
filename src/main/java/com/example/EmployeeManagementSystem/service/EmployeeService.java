package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.dto.EmployeeDto;
import com.example.EmployeeManagementSystem.entity.Employee;
import org.springframework.stereotype.Service;
import java.util.List;

public interface EmployeeService {
    EmployeeDto CreateEmployees(EmployeeDto employeeDto);
    EmployeeDto GetEmployeeById(long id);
    List<EmployeeDto> GetAllEmployee();
    EmployeeDto UpdateEmployee( Long employeeId, EmployeeDto updateEmployee);
    void Delete(Long id);
}
