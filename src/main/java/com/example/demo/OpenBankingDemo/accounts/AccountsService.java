package com.example.demo.OpenBankingDemo.accounts;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsService {
    private final AccountsRepository accountsRepository;

    public AccountsService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    //find Accounts by Id
    public Optional<Accounts> findAccountsById(Integer id){
        return accountsRepository.findById(id);
    }

    //find all Accounts
    public List<Accounts> findAllAccounts(){
         return accountsRepository.findAll();
    }
    public void deleteAccountById(Integer id){
        accountsRepository.deleteById(id);
    }

}
