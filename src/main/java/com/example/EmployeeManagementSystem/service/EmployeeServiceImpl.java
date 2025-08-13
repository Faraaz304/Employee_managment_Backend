package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.dto.EmployeeDto;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.exception.ResourceNotFound;
import com.example.EmployeeManagementSystem.mapper.EmployeeMapper;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto CreateEmployees(EmployeeDto employeeDto) {
        Employee employee =EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedemployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedemployee);
    }

    @Override
    public EmployeeDto GetEmployeeById(long id) {
         Employee employee =  employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Employee not found"));
         return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> GetAllEmployee() {

         List<Employee> employees =  employeeRepository.findAll();

        return employees.stream().map(x ->EmployeeMapper.mapToEmployeeDto(x))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto UpdateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFound("sorry not found"));

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());
        Employee employeedto =   employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(employeedto);
    }

    @Override
    public void Delete(Long id) {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee not found"));
        employeeRepository.deleteById(id);
    }

}
