package com.example.demo.OpenBankingDemo.balances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/balances")
public class BalancesController {
    @Autowired
    private final BalancesService balancesService;

    public BalancesController(BalancesService balancesService) {
        this.balancesService = balancesService;
    }
    @GetMapping(path= "/")
    public List<Balances> getAllTransactions(){
        return balancesService.getAllTransactions();
    }
    @GetMapping(path = "/{id}")
    public Balances getTransactionsById(@PathVariable("id") Integer id){
        return balancesService.getTransactions(id);
    }

    @PostMapping
    public ResponseEntity addAccounts(@RequestBody Balances balances){
        String addAccountResponse= balancesService.addTransactions(balances);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity removeAccountByID(@PathVariable("id") Integer id) throws Exception{
        Balances balances = balancesService.getTransactions(id);
        balancesService.deleteTransactionById(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
