package com.example.demo.OpenBankingDemo.accounts;

import com.example.demo.OpenBankingDemo.exception.ElementAlreadyExistsException;
import com.example.demo.OpenBankingDemo.exception.NoSuchElementFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl
            implements AccountService{

    @Autowired
    private AccountsRepository accountsRepository;

    //Method to get an account by accountID.throws NoSuchElementFoundException
    @Override
    public Accounts getAccounts(Integer id) {
        return accountsRepository.findById(id).orElseThrow(
                ()
                    -> new NoSuchElementFoundException("No account present with id: "+id));
    }

    @Override
    public List<Accounts> getAllAccounts() {
        return accountsRepository.findAll();
    }

    //Method to add an account if it doesn't already exist in the database
    @Override
    public String addAccounts(Accounts accounts) {
        Integer id = accounts.getAccountId();
//        System.out.println("Printing the account id"+id);
        Optional<Accounts> accounts1 = accountsRepository.findById(id);
//        System.out.println("Printing Accounts id being returned from db"+accounts1);
        if((accounts1.isPresent())){
            throw new ElementAlreadyExistsException("Account already exists with id: "+accounts.getAccountId());
        }
        else{
            accountsRepository.save(accounts);
            return "Account has been successfully created !!";
        }

    }

    @Override
    public String updateAccounts(Accounts accounts) {
        return null;
    }

    @Override
    public String deleteAccountById(Integer id) {
        accountsRepository.deleteById(id);
        return "Account has been successfully deleted";
    }
}
