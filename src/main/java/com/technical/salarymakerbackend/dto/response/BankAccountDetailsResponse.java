package com.technical.salarymakerbackend.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BankAccountDetailsResponse {
    private String accountNo;
    private String acHolderName;
    private String accountType;
    private String currentBalance;
    private String bankName;
    private String branchName;

}
