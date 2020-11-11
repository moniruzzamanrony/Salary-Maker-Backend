package com.technical.salarymakerbackend.config;

import com.technical.salarymakerbackend.domain.model.Bank;
import com.technical.salarymakerbackend.domain.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private BankRepository bankRepository;

    @Autowired
    public DataLoader(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public void run(ApplicationArguments args) {
        Bank bank = new Bank();
        bank.setAccountNo("42885412");
        bank.setAccountType("current");
        bank.setAcHolderName("IT Software Limited");
        bank.setBankName("Dutch Bangla Bank");
        bank.setBranchName("Savar Branch");
        bank.setCurrentBalance("12000000");
        bankRepository.save(bank);
    }
}
