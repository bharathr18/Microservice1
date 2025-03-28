package com.project.employee_service.controller;

import com.project.employee_service.entity.Employee;
import com.project.employee_service.response.EmployeeResponse;
import com.project.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getemployee/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable("id") int id)
    {
        EmployeeResponse response = employeeService.getEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
