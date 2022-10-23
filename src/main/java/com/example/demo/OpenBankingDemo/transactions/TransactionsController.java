package com.example.demo.OpenBankingDemo.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/transactions")
public class TransactionsController {
    @Autowired
    private final TransactionService transactionService;

    public TransactionsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping(path= "/")
    public List<Transactions> getAllTransactions(){
        return transactionService.getAllTransactions();
    }
    @GetMapping(path = "/{id}")
    public Transactions getTransactionsById(@PathVariable("id") Integer id){
        return transactionService.getTransactions(id);
    }

    @PostMapping
    public ResponseEntity addAccounts(@RequestBody Transactions transactions){
        String addAccountResponse= transactionService.addTransactions(transactions);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity removeAccountByID(@PathVariable("id") Integer id) throws Exception{
        Transactions transactions = transactionService.getTransactions(id);
        transactionService.deleteTransactionById(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
