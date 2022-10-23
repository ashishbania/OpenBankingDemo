package com.example.demo.OpenBankingDemo.statements;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatementsRepository extends CrudRepository<Statements, Integer> {
    @Override
    Optional<Statements> findById(Integer id);

    @Override
    List<Statements> findAll();

    @Override
    void deleteById(Integer integer);
}
