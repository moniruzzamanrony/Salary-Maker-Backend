package com.technical.salarymakerbackend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddMoneyRequest {
    private String acNo;
    private String amount;

}
