package com.example.demo.OpenBankingDemo.accounts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts,Integer> {
    @Override
    Optional<Accounts> findById(Integer id);

    @Override
    List<Accounts> findAll();

    @Override
    void deleteById(Integer integer);
}
