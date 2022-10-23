package com.example.demo.OpenBankingDemo.accounts;

import java.util.List;

public interface AccountService {
    //Method to get account by account id
    Accounts getAccounts(Integer id);

    //Method to get all the accounts
    List<Accounts> getAllAccounts();

    //Method to add a new Account to the database
    String addAccounts(Accounts accounts);

    //Method to update the account in the database
    String updateAccounts(Accounts accounts);

    String deleteAccountById(Integer id);
}
