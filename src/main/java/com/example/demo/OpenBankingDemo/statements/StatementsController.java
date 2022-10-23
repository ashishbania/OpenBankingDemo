package com.example.demo.OpenBankingDemo.statements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/statements")
public class StatementsController {
    @Autowired
    private final StatementsService statementsService;

    public StatementsController(StatementsService statementsService) {
        this.statementsService = statementsService;
    }
    @GetMapping(path= "/")
    public List<Statements> getAllTransactions(){
        return statementsService.getAllTransactions();
    }
    @GetMapping(path = "/{id}")
    public Statements getTransactionsById(@PathVariable("id") Integer id){
        return statementsService.getTransactions(id);
    }

    @PostMapping
    public ResponseEntity addAccounts(@RequestBody Statements statements){
        String addAccountResponse= statementsService.addTransactions(statements);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity removeAccountByID(@PathVariable("id") Integer id) throws Exception{
        Statements statements = statementsService.getTransactions(id);
        statementsService.deleteTransactionById(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
