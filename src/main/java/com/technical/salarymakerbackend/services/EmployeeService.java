package com.technical.salarymakerbackend.services;

import com.technical.salarymakerbackend.config.Utility;
import com.technical.salarymakerbackend.domain.model.Bank;
import com.technical.salarymakerbackend.domain.model.Employee;
import com.technical.salarymakerbackend.domain.repository.BankRepository;
import com.technical.salarymakerbackend.domain.repository.EmployeeRepository;
import com.technical.salarymakerbackend.dto.request.AddNewEmployeeRequest;
import com.technical.salarymakerbackend.dto.request.SalarySheetRequest;
import com.technical.salarymakerbackend.dto.response.BankAccountDetailsResponse;
import com.technical.salarymakerbackend.dto.response.SalaryResponse;
import com.technical.salarymakerbackend.dto.response.SalarySheetResponse;
import com.technical.salarymakerbackend.dto.response.SheetResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final BankRepository bankRepository;

    public ResponseEntity<Void> addNewEmployee(AddNewEmployeeRequest addNewEmployeeRequest) {

        Bank bank = new Bank();
        bank.setAccountNo(addNewEmployeeRequest.getAcNo());
        bank.setAccountType(addNewEmployeeRequest.getAcNo());
        bank.setAcHolderName(addNewEmployeeRequest.getAcNo());
        bank.setBankName(addNewEmployeeRequest.getAcNo());
        bank.setCurrentBalance(0.0);
        bank.setBranchName(addNewEmployeeRequest.getAcNo());

        Employee employee = new Employee();
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
        return new ResponseEntity(employeeRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<SalarySheetResponse> getEmployeesSalary(SalarySheetRequest salarySheetRequest) {
        List<SheetResponse> sheetResponseList = new ArrayList<>();

        List<SalaryResponse> salaryResponseOneList = new ArrayList<>();
        List<SalaryResponse> salaryResponseTwoList = new ArrayList<>();
        List<SalaryResponse> salaryResponseThreeList = new ArrayList<>();
        List<SalaryResponse> salaryResponseFourList = new ArrayList<>();
        List<SalaryResponse> salaryResponseFiveList = new ArrayList<>();
        List<SalaryResponse> salaryResponseSixList = new ArrayList<>();

        List<Employee> employeeList = employeeRepository.findAll();

        double totalPaidSalary = 0.0;

        for (Employee employee : employeeList) {
            System.out.println(employee.getGradeOfEmployee().toLowerCase());
            SalaryResponse salaryResponse = null;
            if (employee.getGradeOfEmployee().toLowerCase().equals("grade 6")) {
                salaryResponse = getSalaryResponse(employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeMobileNo(), Double.valueOf(salarySheetRequest.getBasicSalary()),employee.getBank().getAccountNo());

                salaryResponseSixList.add(salaryResponse);
            } else if (employee.getGradeOfEmployee().toLowerCase().equals("grade 5")) {
                double mySalary = Double.valueOf(salarySheetRequest.getBasicSalary()) + (5000 * (6 - Double.valueOf(employee.getGradeOfEmployee().substring(employee.getGradeOfEmployee().length() - 1))));
                salaryResponse = getSalaryResponse(employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeMobileNo(), mySalary,employee.getBank().getAccountNo());
                salaryResponseFiveList.add(salaryResponse);
            } else if (employee.getGradeOfEmployee().toLowerCase().equals("grade 4")) {
                double mySalary = Double.valueOf(salarySheetRequest.getBasicSalary()) + (5000 * (6 - Double.valueOf(employee.getGradeOfEmployee().substring(employee.getGradeOfEmployee().length() - 1))));
                salaryResponse = getSalaryResponse(employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeMobileNo(), mySalary,employee.getBank().getAccountNo());
                salaryResponseFourList.add(salaryResponse);
            } else if (employee.getGradeOfEmployee().toLowerCase().equals("grade 3")) {
                double mySalary = Double.valueOf(salarySheetRequest.getBasicSalary()) + (5000 * (6 - Double.valueOf(employee.getGradeOfEmployee().substring(employee.getGradeOfEmployee().length() - 1))));
                salaryResponse = getSalaryResponse(employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeMobileNo(), mySalary,employee.getBank().getAccountNo());
                salaryResponseThreeList.add(salaryResponse);
            } else if (employee.getGradeOfEmployee().toLowerCase().equals("grade 2")) {
                double mySalary = Double.valueOf(salarySheetRequest.getBasicSalary()) + (5000 * (6 - Double.valueOf(employee.getGradeOfEmployee().substring(employee.getGradeOfEmployee().length() - 1))));
                salaryResponse = getSalaryResponse(employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeMobileNo(),mySalary,employee.getBank().getAccountNo());
                salaryResponseTwoList.add(salaryResponse);
            } else if (employee.getGradeOfEmployee().toLowerCase().equals("grade 1")) {
                double mySalary = Double.valueOf(salarySheetRequest.getBasicSalary()) + (5000 * (6 - Double.valueOf(employee.getGradeOfEmployee().substring(employee.getGradeOfEmployee().length() - 1))));
                salaryResponse = getSalaryResponse(employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeMobileNo(), mySalary,employee.getBank().getAccountNo());
                salaryResponseOneList.add(salaryResponse);
            }
            totalPaidSalary = totalPaidSalary + salaryResponse.getTotalSalary();
        }


        SheetResponse sheetResponseForSix = new SheetResponse();
        sheetResponseForSix.setGrade("6");
        sheetResponseForSix.setSalary(salaryResponseSixList);
        sheetResponseList.add(sheetResponseForSix);

        SheetResponse sheetResponseForFive = new SheetResponse();
        sheetResponseForFive.setGrade("5");
        sheetResponseForFive.setSalary(salaryResponseFiveList);
        sheetResponseList.add(sheetResponseForFive);

        SheetResponse sheetResponseForFour = new SheetResponse();
        sheetResponseForFour.setGrade("4");
        sheetResponseForFour.setSalary(salaryResponseFourList);
        sheetResponseList.add(sheetResponseForFour);

        SheetResponse sheetResponseForThree = new SheetResponse();
        sheetResponseForThree.setGrade("3");
        sheetResponseForThree.setSalary(salaryResponseThreeList);
        sheetResponseList.add(sheetResponseForThree);

        SheetResponse sheetResponseForTwo = new SheetResponse();
        sheetResponseForTwo.setGrade("2");
        sheetResponseForTwo.setSalary(salaryResponseTwoList);
        sheetResponseList.add(sheetResponseForTwo);

        SheetResponse sheetResponseForOne = new SheetResponse();
        sheetResponseForOne.setGrade("1");
        sheetResponseForOne.setSalary(salaryResponseOneList);
        sheetResponseList.add(sheetResponseForOne);

        SalarySheetResponse salarySheetResponse = new SalarySheetResponse();
        salarySheetResponse.setMonthAndYear(salarySheetRequest.getDateAndYear());
        salarySheetResponse.setTotalPaidSalary(String.valueOf(totalPaidSalary));
        salarySheetResponse.setSheet(sheetResponseList);

        addBalanceInBank("42885412",String.valueOf(getCurrentBalance("42885412") - totalPaidSalary));

        return new ResponseEntity(salarySheetResponse,HttpStatus.OK);
    }

    public double getCurrentBalance(String acNo) {
       Optional<Bank> bankOptional= bankRepository.findById(acNo);
       if(!bankOptional.isPresent())
       {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Bank Ac Not Found");
       }
       return Double.valueOf(bankOptional.get().getCurrentBalance());
    }

    private SalaryResponse getSalaryResponse(String employeeId, String employeeName, String employeeMobileNo, double basicSalary,String acNo) {

        double houseRant = basicSalary * 0.2;
        double medicalAllowance = basicSalary * 0.15;
        double total = basicSalary+ houseRant + medicalAllowance;
        SalaryResponse salaryResponse = new SalaryResponse();
        salaryResponse.setEmployeeId(employeeId);
        salaryResponse.setEmployeeName(employeeName);
        salaryResponse.setEmployeePhoneNo(employeeMobileNo);
        salaryResponse.setBasic(basicSalary);
        salaryResponse.setHouseRant(houseRant);
        salaryResponse.setMedicalAllowance(medicalAllowance);
        salaryResponse.setTotalSalary(total);
        addBalanceInBank(acNo,String.valueOf(total));
        withdrawBalanceInBank("42885412",String.valueOf(total));
        return salaryResponse;
    }

    public void addBalanceInBank(String acNo,String amount) {
        Optional<Bank> optionalBank=bankRepository.findById(acNo);
        if(!optionalBank.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Bank Ac Not Found");
        }
        Bank bank= optionalBank.get();
        double currentBalance = Double.valueOf(bank.getCurrentBalance()) + Double.valueOf(amount);
        bank.setCurrentBalance(currentBalance);
        bankRepository.save(bank);
    }

    private void withdrawBalanceInBank(String acNo,String amount) {
        Optional<Bank> optionalBank=bankRepository.findById(acNo);
        if(!optionalBank.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Bank Ac Not Found");
        }
        Bank bank= optionalBank.get();
        double currentBalance =Double.valueOf(bank.getCurrentBalance()) - Double.valueOf(amount);
        bank.setCurrentBalance(currentBalance);
        bankRepository.save(bank);
    }

    public ResponseEntity<BankAccountDetailsResponse> getMyAccountDetails(String acNo) {
        Optional<Bank> optionalBank=bankRepository.findById(acNo);
        if(!optionalBank.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Bank Ac Not Found");
        }
        Bank bank= optionalBank.get();
        BankAccountDetailsResponse bankAccountDetailsResponse = new BankAccountDetailsResponse();
        bankAccountDetailsResponse.setAccountNo(bank.getAccountNo());
        bankAccountDetailsResponse.setAccountType(bank.getAccountType());
        bankAccountDetailsResponse.setAcHolderName(bank.getAcHolderName());
        bankAccountDetailsResponse.setBankName(bank.getBankName());
        bankAccountDetailsResponse.setBranchName(bank.getBranchName());
        bankAccountDetailsResponse.setCurrentBalance(Double.valueOf(bank.getCurrentBalance()));

        return new ResponseEntity(bankAccountDetailsResponse,HttpStatus.OK);
    }
}
