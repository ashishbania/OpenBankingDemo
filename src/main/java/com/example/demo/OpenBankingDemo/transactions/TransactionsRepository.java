package com.example.demo.OpenBankingDemo.transactions;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionsRepository extends CrudRepository<Transactions, Integer> {
    @Override
    Optional<Transactions> findById(Integer id);

    @Override
    List<Transactions> findAll();

    @Override
    void deleteById(Integer integer);
}
