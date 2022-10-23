package com.example.demo.OpenBankingDemo.transactions;

import com.example.demo.OpenBankingDemo.exception.ElementAlreadyExistsException;
import com.example.demo.OpenBankingDemo.exception.NoSuchElementFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl
        implements TransactionService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    //Method to get transaction by transactionId. throws NoSuchElementFoundException
    @Override
    public Transactions getTransactions(Integer id) {
        return transactionsRepository.findById(id).orElseThrow(
                ()
                        -> new NoSuchElementFoundException("No transactions present with id: " + id));
    }

    @Override
    public List<Transactions> getAllTransactions() {
        return transactionsRepository.findAll();
    }


    //Method to add an account if it doesn't already exist in the database
    @Override
    public String addTransactions(Transactions transactions) {
        Integer id = transactions.getTransactionId();
//        System.out.println("Printing the account id"+id);
        Optional<Transactions> transactions1 = transactionsRepository.findById(id);
//        System.out.println("Printing Accounts id being returned from db"+accounts1);
        if ((transactions1.isPresent())) {
            throw new ElementAlreadyExistsException("Transaction already exists with id: " + transactions.getTransactionId());
        } else {
            transactionsRepository.save(transactions);
            return "Transaction has been successfully posted !!";
        }
    }

    @Override
    public String updateTransactions(Transactions transactions) {
        return null;
    }

    @Override
    public String deleteTransactionById(Integer id) {
        transactionsRepository.deleteById(id);
        return "Transaction has been successfully deleted";
    }
}
