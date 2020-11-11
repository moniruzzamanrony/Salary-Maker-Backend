package com.technical.salarymakerbackend.services;

import com.technical.salarymakerbackend.config.Utility;
import com.technical.salarymakerbackend.domain.model.Bank;
import com.technical.salarymakerbackend.domain.model.Employee;
import com.technical.salarymakerbackend.domain.repository.EmployeeRepository;
import com.technical.salarymakerbackend.dto.request.AddNewEmployeeRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public ResponseEntity<Void> addNewEmployee(AddNewEmployeeRequest addNewEmployeeRequest) {

        Bank bank = new Bank();
        bank.setAccountNo(addNewEmployeeRequest.getAcNo());
        bank.setAccountType(addNewEmployeeRequest.getAcNo());
        bank.setAcHolderName(addNewEmployeeRequest.getAcNo());
        bank.setBankName(addNewEmployeeRequest.getAcNo());
        bank.setBranchName(addNewEmployeeRequest.getAcNo());

        Employee employee= new Employee();
        employee.setEmployeeId(String.valueOf(Utility.getRandomId()));
        employee.setEmployeeAddress(addNewEmployeeRequest.getAddress());
        employee.setEmployeeMobileNo(addNewEmployeeRequest.getPhoneNo());
        employee.setEmployeeName(addNewEmployeeRequest.getName());
        employee.setGradeOfEmployee(addNewEmployeeRequest.getRank());
        employee.setBank(bank);

        employeeRepository.save(employee);
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity(employeeRepository.findAll(),HttpStatus.OK);
    }
}
