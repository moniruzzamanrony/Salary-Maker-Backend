package com.technical.salarymakerbackend.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SalarySheetResponse {
    private String monthAndYear;
    private String totalPaidSalary;
    private List<SheetResponse> sheet;
}
