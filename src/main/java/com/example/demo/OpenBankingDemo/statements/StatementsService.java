package com.example.demo.OpenBankingDemo.statements;

import java.util.List;

public interface StatementsService {
    //Method to get account by account id
    Statements getTransactions(Integer id);

    //Method to get all the accounts
    List<Statements> getAllTransactions();

    //Method to add a new Account to the database
    String addTransactions(Statements statements);

    //Method to update the account in the database
    String updateTransactions(Statements statements);

    String deleteTransactionById(Integer id);
}
