package com.technical.salarymakerbackend.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SalaryResponse {
    private String employeeId;
    private String employeeName;
    private String employeePhoneNo;
    private double basic;
    private double houseRant;
    private double medicalAllowance;
    private double totalSalary;


}
