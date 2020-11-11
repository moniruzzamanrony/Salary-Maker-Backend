package com.technical.salarymakerbackend.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SheetResponse {
    private String grade;
    private List<SalaryResponse> salary;

}
