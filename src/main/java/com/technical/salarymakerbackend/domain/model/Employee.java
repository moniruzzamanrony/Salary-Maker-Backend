package com.technical.salarymakerbackend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @Size(min = 4,max = 20)
    private String employeeId;

    @NotNull
    @Size(min = 4,max = 20)
    private String employeeName;

    @NotNull
    @Size(min = 1,max = 50)
    private String gradeOfEmployee;


    @Size(min = 1,max = 200)
    private String employeeAddress;

    @NotNull
    @Size(min = 10,max = 15)
    private String employeeMobileNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_table")
    private Bank bank;





}
