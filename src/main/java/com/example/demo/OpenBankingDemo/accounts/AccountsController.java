package com.example.demo.OpenBankingDemo.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/accounts")
public class AccountsController {

    private final AccountsService accountsService;
    @Autowired
    private final AccountService accountService;

    public AccountsController(AccountsService accountsService, AccountService accountService) {
        this.accountsService = accountsService;
        this.accountService = accountService;
    }
    @GetMapping(path= "/")
    public List<Accounts> getAllAccounts(){
        return accountService.getAllAccounts();
    }
    @GetMapping(path = "/{id}")
    public Accounts getAccountById(@PathVariable("id") Integer id){
        return accountService.getAccounts(id);
    }

    @PostMapping
    public ResponseEntity addAccounts(@RequestBody Accounts accounts){
        String addAccountResponse= accountService.addAccounts(accounts);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity removeAccountByID(@PathVariable("id") Integer id) throws Exception{
        Accounts accounts = accountService.getAccounts(id);
        accountService.deleteAccountById(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
