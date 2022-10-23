package com.example.demo.OpenBankingDemo.statements;

import com.example.demo.OpenBankingDemo.exception.ElementAlreadyExistsException;
import com.example.demo.OpenBankingDemo.exception.NoSuchElementFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatementsServiceImpl
        implements StatementsService {

    @Autowired
    private StatementsRepository statementsRepository;

    //Method to get transaction by transactionId. throws NoSuchElementFoundException
    @Override
    public Statements getTransactions(Integer id) {
        return statementsRepository.findById(id).orElseThrow(
                ()
                        -> new NoSuchElementFoundException("No transactions present with id: " + id));
    }

    @Override
    public List<Statements> getAllTransactions() {
        return statementsRepository.findAll();
    }


    //Method to add an account if it doesn't already exist in the database
    @Override
    public String addTransactions(Statements statements) {
        Integer id = statements.getTransactionId();
//        System.out.println("Printing the account id"+id);
        Optional<Statements> transactions1 = statementsRepository.findById(id);
//        System.out.println("Printing Accounts id being returned from db"+accounts1);
        if ((transactions1.isPresent())) {
            throw new ElementAlreadyExistsException("Transaction already exists with id: " + statements.getTransactionId());
        } else {
            statementsRepository.save(statements);
            return "Transaction has been successfully posted !!";
        }
    }

    @Override
    public String updateTransactions(Statements statements) {
        return null;
    }

    @Override
    public String deleteTransactionById(Integer id) {
        statementsRepository.deleteById(id);
        return "Transaction has been successfully deleted";
    }
}
