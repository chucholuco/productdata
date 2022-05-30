package com.bharath.springdata.product.services;

import com.bharath.springdata.product.entities.BankAccount;
import com.bharath.springdata.product.repos.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    private final BankAccountRepository repository;

    public BankAccountServiceImpl(BankAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void transfer(int amount) {
        BankAccount obamasAccount = repository.findById(1).get();
        obamasAccount.setBal(obamasAccount.getBal() - amount);
        repository.save(obamasAccount);

        if (true)
            throw new RuntimeException();

        BankAccount trumpsAccount = repository.findById(2).get();
        trumpsAccount.setBal(trumpsAccount.getBal() + amount);
        repository.save(trumpsAccount);
    }
}
