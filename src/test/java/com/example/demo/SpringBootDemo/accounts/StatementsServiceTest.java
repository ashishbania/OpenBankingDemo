package com.example.demo.SpringBootDemo.accounts;

import com.example.demo.OpenBankingDemo.accounts.Accounts;
import com.example.demo.OpenBankingDemo.accounts.AccountsRepository;
import com.example.demo.OpenBankingDemo.accounts.AccountsService;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class StatementsServiceTest {

    @Mock
    private AccountsRepository accountsRepository;

    @InjectMocks
    private AccountsService accountsService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAccountsById() {
        Accounts accounts1 = new Accounts(
                1,
                "Enabled",
                "2020/07/21",
                "USD",
                "Business",
                "2018/01/11"
        );
        when(accountsRepository.findById(1)).thenReturn(Optional.of(accounts1));
        Optional<Accounts> resultOpt = accountsService.findAccountsById(1);
        Accounts account = resultOpt.get();
        assertEquals(Optional.of(1), Optional.ofNullable(account.getAccountId()));
        assertEquals("Business", account.getAccountType());
        assertEquals("USD", account.getCurrency());
    }

    @Test
    public void findAllAccounts() {
        List<Accounts> accountsList = new ArrayList<Accounts>();
        Accounts accounts1 = new Accounts(
                1,
                "Enabled",
                "2020/07/21",
                "USD",
                "Business",
                "2018/01/11"
        );
        Accounts accounts2 = new Accounts(
                2,
                "Disabled",
                "2020/07/21",
                "USD",
                "Business",
                "2018/01/11"
        );
        accountsList.add(accounts1);
        accountsList.add(accounts2);
        when(accountsRepository.findAll()).thenReturn(accountsList);

        List<Accounts> result = accountsService.findAllAccounts();
        assertEquals(2, result.size());
    }

    @Test
    public void deleteAccountById() {
    }
}