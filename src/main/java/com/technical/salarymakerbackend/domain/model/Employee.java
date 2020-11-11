package com.technical.salarymakerbackend.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @Size(min = 4,max = 20)
    private String employeeId;


    private String employeeName;


    private String gradeOfEmployee;


    private String employeeAddress;

    private String employeeMobileNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_table")
    private Bank bank;





}
