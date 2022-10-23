package com.example.demo.OpenBankingDemo.transactions;

import java.util.List;

public interface TransactionService {
    //Method to get account by account id
    Transactions getTransactions(Integer id);

    //Method to get all the accounts
    List<Transactions> getAllTransactions();

    //Method to add a new Account to the database
    String addTransactions(Transactions transactions);

    //Method to update the account in the database
    String updateTransactions(Transactions transactions);

    String deleteTransactionById(Integer id);
}
