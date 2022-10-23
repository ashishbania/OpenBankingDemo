package com.example.demo.OpenBankingDemo.balances;

import com.example.demo.OpenBankingDemo.exception.ElementAlreadyExistsException;
import com.example.demo.OpenBankingDemo.exception.NoSuchElementFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalancesServiceImpl
        implements BalancesService {

    @Autowired
    private BalancesRepository balancesRepository;

    //Method to get transaction by transactionId. throws NoSuchElementFoundException
    @Override
    public Balances getTransactions(Integer id) {
        return balancesRepository.findById(id).orElseThrow(
                ()
                        -> new NoSuchElementFoundException("No transactions present with id: " + id));
    }

    @Override
    public List<Balances> getAllTransactions() {
        return balancesRepository.findAll();
    }


    //Method to add an account if it doesn't already exist in the database
    @Override
    public String addTransactions(Balances balances) {
        Integer id = balances.getTransactionId();
//        System.out.println("Printing the account id"+id);
        Optional<Balances> transactions1 = balancesRepository.findById(id);
//        System.out.println("Printing Accounts id being returned from db"+accounts1);
        if ((transactions1.isPresent())) {
            throw new ElementAlreadyExistsException("Transaction already exists with id: " + balances.getTransactionId());
        } else {
            balancesRepository.save(balances);
            return "Transaction has been successfully posted !!";
        }
    }

    @Override
    public String updateTransactions(Balances balances) {
        return null;
    }

    @Override
    public String deleteTransactionById(Integer id) {
        balancesRepository.deleteById(id);
        return "Transaction has been successfully deleted";
    }
}
