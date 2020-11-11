package com.technical.salarymakerbackend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddNewEmployeeRequest {
    private String name;
    private String rank;
    private String phoneNo;
    private String address;
    private String bankName;
    private String branchName;
    private String acNo;
    private String acType;
}
