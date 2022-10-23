package com.example.demo.SpringBootDemo.accounts;

import com.example.demo.OpenBankingDemo.accounts.Accounts;
import com.example.demo.OpenBankingDemo.accounts.AccountsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class StatementsRepositoryTests {
    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void findById() {

    }

    @Test
    public void findAll() {
        List<Accounts> accountsList = accountsRepository.findAll();
        assertNotNull(accountsList);
    }
}