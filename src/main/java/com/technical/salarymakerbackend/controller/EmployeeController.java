package com.technical.salarymakerbackend.controller;

import com.technical.salarymakerbackend.domain.model.Employee;
import com.technical.salarymakerbackend.dto.request.AddNewEmployeeRequest;
import com.technical.salarymakerbackend.dto.request.SalarySheetRequest;
import com.technical.salarymakerbackend.dto.response.SalarySheetResponse;
import com.technical.salarymakerbackend.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Void> addNewEmployee(@RequestBody AddNewEmployeeRequest addNewEmployeeRequest)
    {
        return employeeService.addNewEmployee(addNewEmployeeRequest);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getEmployees()
    {
        return employeeService.getEmployees();
    }

    @GetMapping("/salary")
    public ResponseEntity<SalarySheetResponse> getEmployeesSalary(@RequestBody SalarySheetRequest salarySheetRequest)
    {
        return employeeService.getEmployeesSalary(salarySheetRequest);
    }
}
