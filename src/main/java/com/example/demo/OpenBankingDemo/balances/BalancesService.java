package com.example.demo.OpenBankingDemo.balances;

import java.util.List;

public interface BalancesService {
    //Method to get account by account id
    Balances getTransactions(Integer id);

    //Method to get all the accounts
    List<Balances> getAllTransactions();

    //Method to add a new Account to the database
    String addTransactions(Balances balances);

    //Method to update the account in the database
    String updateTransactions(Balances balances);

    String deleteTransactionById(Integer id);
}
