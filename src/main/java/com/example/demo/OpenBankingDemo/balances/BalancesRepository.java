package com.example.demo.OpenBankingDemo.balances;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BalancesRepository extends CrudRepository<Balances, Integer> {
    @Override
    Optional<Balances> findById(Integer id);

    @Override
    List<Balances> findAll();

    @Override
    void deleteById(Integer integer);
}
