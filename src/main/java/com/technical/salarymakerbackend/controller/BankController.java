package com.technical.salarymakerbackend.controller;

import com.technical.salarymakerbackend.domain.model.Employee;
import com.technical.salarymakerbackend.dto.request.AddMoneyRequest;
import com.technical.salarymakerbackend.dto.request.AddNewEmployeeRequest;
import com.technical.salarymakerbackend.dto.request.SalarySheetRequest;
import com.technical.salarymakerbackend.dto.response.BankAccountDetailsResponse;
import com.technical.salarymakerbackend.dto.response.SalarySheetResponse;
import com.technical.salarymakerbackend.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("bank")
public class BankController {
    private final EmployeeService employeeService;

    @GetMapping("/accounts/{acNo}/details")
    public ResponseEntity<BankAccountDetailsResponse> getMyAccountDetails(@PathVariable String acNo)
    {
        return employeeService.getMyAccountDetails(acNo);
    }

    @PutMapping("/add/balance")
    public ResponseEntity<Void> addBalance(@RequestBody AddMoneyRequest addMoneyRequest)
    {
        employeeService.addBalanceInBank(addMoneyRequest.getAcNo(),addMoneyRequest.getAmount());
        return new ResponseEntity(HttpStatus.OK);
    }
}
