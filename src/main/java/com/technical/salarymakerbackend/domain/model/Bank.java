package com.technical.salarymakerbackend.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @Size(min = 4,max = 20)
    private String acHolderName;

    @NotNull
    @Size(min = 4,max = 20)
    private String accountType;

    private String currentBalance;

    @NotNull
    @Size(min = 4,max = 20)
    private String bankName;

    @NotNull
    @Size(min = 4,max = 20)
    private String branchName;
}
