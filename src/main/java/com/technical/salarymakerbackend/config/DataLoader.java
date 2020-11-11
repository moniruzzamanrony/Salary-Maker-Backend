package com.technical.salarymakerbackend.config;

import com.technical.salarymakerbackend.domain.model.Bank;
import com.technical.salarymakerbackend.domain.model.Employee;
import com.technical.salarymakerbackend.domain.repository.BankRepository;
import com.technical.salarymakerbackend.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private BankRepository bankRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public DataLoader(BankRepository bankRepository, EmployeeRepository employeeRepository) {
        this.bankRepository = bankRepository;
        this.employeeRepository = employeeRepository;
    }

    public void run(ApplicationArguments args) {
        Bank companyAC = new Bank();
        companyAC.setAccountNo("42885412");
        companyAC.setAccountType("current");
        companyAC.setAcHolderName("IT Software Limited");
        companyAC.setBankName("Dutch Bangla Bank");
        companyAC.setBranchName("Savar Branch");
        companyAC.setCurrentBalance(120000000.0);
        bankRepository.saveAndFlush(companyAC);

        Bank bank11 = new Bank();
        bank11.setAccountNo("123456");
        bank11.setAccountType("Saving");
        bank11.setAcHolderName("Hassan Ohid");
        bank11.setBankName("DBBL");
        bank11.setCurrentBalance(0.0);
        bank11.setBranchName("Asulia Branch");
        Employee employee11 = new Employee();
        employee11.setEmployeeId("12345");
        employee11.setEmployeeAddress("Asulia,Savar,Dhaka");
        employee11.setEmployeeMobileNo("01988876789");
        employee11.setEmployeeName("Hassan Ohid");
        employee11.setGradeOfEmployee("Grade 1");
        employee11.setBank(bank11);
        employeeRepository.saveAndFlush(employee11);

        Bank bank21 = new Bank();
        bank21.setAccountNo("123411");
        bank21.setAccountType("Saving");
        bank21.setAcHolderName("Asikur Rahman Nisad");
        bank21.setBankName("DBBL");
        bank21.setCurrentBalance(0.0);
        bank21.setBranchName("Mirpur Branch");
        Employee employee21 = new Employee();
        employee21.setEmployeeId("12455");
        employee21.setEmployeeAddress("Asulia,Savar,Dhaka");
        employee21.setEmployeeMobileNo("01988876781");
        employee21.setEmployeeName("Asikur Rahman Nisad");
        employee21.setGradeOfEmployee("Grade 2");
        employee21.setBank(bank21);
        employeeRepository.saveAndFlush(employee21);

        Bank bank31 = new Bank();
        bank31.setAccountNo("12045");
        bank31.setAccountType("Saving");
        bank31.setAcHolderName("Asikur Rahman");
        bank31.setBankName("DBBL");
        bank31.setCurrentBalance(0.0);
        bank31.setBranchName("Mirpur Branch");
        Employee employee31 = new Employee();
        employee31.setEmployeeId("00345");
        employee31.setEmployeeAddress("Asulia,Savar,Dhaka");
        employee31.setEmployeeMobileNo("01988876785");
        employee31.setEmployeeName("Asikur Rahman");
        employee31.setGradeOfEmployee("Grade 3");
        employee31.setBank(bank31);
        employeeRepository.saveAndFlush(employee31);

        Bank bank32 = new Bank();
        bank32.setAccountNo("10305");
        bank32.setAccountType("Saving");
        bank32.setAcHolderName("Asikur");
        bank32.setBankName("DBBL");
        bank32.setCurrentBalance(0.0);
        bank32.setBranchName("Mirpur Branch");
        Employee employee32 = new Employee();
        employee32.setEmployeeId("13335");
        employee32.setEmployeeAddress("Asulia,Savar,Dhaka");
        employee32.setEmployeeMobileNo("01988876785");
        employee32.setEmployeeName("Asikur");
        employee32.setGradeOfEmployee("Grade 3");
        employee32.setBank(bank32);
        employeeRepository.saveAndFlush(employee32);

        Bank bank41 = new Bank();
        bank41.setAccountNo("17775");
        bank41.setAccountType("Saving");
        bank41.setAcHolderName("Hassan");
        bank41.setBankName("DBBL");
        bank41.setCurrentBalance(0.0);
        bank41.setBranchName("Asulia Branch");
        Employee employee41 = new Employee();
        employee41.setEmployeeId("11115");
        employee41.setEmployeeAddress("Asulia,Savar,Dhaka");
        employee41.setEmployeeMobileNo("01988876789");
        employee41.setEmployeeName("Hassan");
        employee41.setGradeOfEmployee("Grade 4");
        employee41.setBank(bank41);
        employeeRepository.saveAndFlush(employee41);

        Bank bank42 = new Bank();
        bank42.setAccountNo("15555");
        bank42.setAccountType("Saving");
        bank42.setAcHolderName("Asikur Nisad");
        bank42.setBankName("DBBL");
        bank42.setCurrentBalance(0.0);
        bank42.setBranchName("Mirpur Branch");
        Employee employee42 = new Employee();
        employee42.setEmployeeId("12222");
        employee42.setEmployeeAddress("Asulia,Savar,Dhaka");
        employee42.setEmployeeMobileNo("01988876781");
        employee42.setEmployeeName("Asikur Nisad");
        employee42.setGradeOfEmployee("Grade 4");
        employee42.setBank(bank42);
        employeeRepository.saveAndFlush(employee42);

        Bank bank51 = new Bank();
        bank51.setAccountNo("11111");
        bank51.setAccountType("Saving");
        bank51.setAcHolderName("Nisad Rahman");
        bank51.setBankName("DBBL");
        bank51.setCurrentBalance(0.0);
        bank51.setBranchName("Mirpur Branch");
        Employee employee51 = new Employee();
        employee51.setEmployeeId("10000");
        employee51.setEmployeeAddress("Asulia,Savar,Dhaka");
        employee51.setEmployeeMobileNo("01988876785");
        employee51.setEmployeeName("Nisad Rahman");
        employee51.setGradeOfEmployee("Grade 5");
        employee51.setBank(bank51);
        employeeRepository.saveAndFlush(employee51);

        Bank bank52 = new Bank();
        bank52.setAccountNo("98765");
        bank52.setAccountType("Saving");
        bank52.setAcHolderName("Asik");
        bank52.setBankName("DBBL");
        bank52.setCurrentBalance(0.0);
        bank52.setBranchName("Mirpur Branch");
        Employee employee52 = new Employee();
        employee52.setEmployeeId("56873");
        employee52.setEmployeeAddress("Asulia,Savar,Dhaka");
        employee52.setEmployeeMobileNo("01988876785");
        employee52.setEmployeeName("Asik");
        employee52.setGradeOfEmployee("Grade 5");
        employee52.setBank(bank52);
        employeeRepository.saveAndFlush(employee52);

        Bank bank61 = new Bank();
        bank61.setAccountNo("98445");
        bank61.setAccountType("Saving");
        bank61.setAcHolderName("Moniruzzaman Rony");
        bank61.setBankName("DBBL");
        bank61.setCurrentBalance(0.0);
        bank61.setBranchName("Mirpur Branch");
        Employee employee61 = new Employee();
        employee61.setEmployeeId("34543");
        employee61.setEmployeeAddress("Asulia,Savar,Dhaka");
        employee61.setEmployeeMobileNo("01988876785");
        employee61.setEmployeeName("Moniruzzaman Rony");
        employee61.setGradeOfEmployee("Grade 6");
        employee61.setBank(bank61);
        employeeRepository.saveAndFlush(employee61);

        Bank bank62 = new Bank();
        bank62.setAccountNo("76345");
        bank62.setAccountType("Saving");
        bank62.setAcHolderName("Moniruzzaman");
        bank62.setBankName("DBBL");
        bank62.setCurrentBalance(0.0);
        bank62.setBranchName("Mirpur Branch");
        Employee employee62 = new Employee();
        employee62.setEmployeeId("23760");
        employee62.setEmployeeAddress("Asulia,Savar,Dhaka");
        employee62.setEmployeeMobileNo("01988876785");
        employee62.setEmployeeName("Moniruzzaman");
        employee62.setGradeOfEmployee("Grade 6");
        employee62.setBank(bank62);
        employeeRepository.saveAndFlush(employee62);
    }
}
