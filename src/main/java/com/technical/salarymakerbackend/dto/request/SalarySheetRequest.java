package com.technical.salarymakerbackend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SalarySheetRequest {
    private String basicSalary;
    private String dateAndYear;
}
