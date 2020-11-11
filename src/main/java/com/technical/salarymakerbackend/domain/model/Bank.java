package com.technical.salarymakerbackend.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "bank")
public class Bank {

    @Id
    @Size(min = 4,max = 20)
    private String accountNo;


    private String acHolderName;


    private String accountType;

    private Double currentBalance;


    private String bankName;


    private String branchName;
}
