package com.example.demo.OpenBankingDemo.accounts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class AccountsConfig {
    @Bean
    CommandLineRunner commandLineRunnerAccounts(AccountsRepository accountsRepository){
        return args -> {
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
            accountsRepository.saveAll(Arrays.asList(accounts1,accounts2));
        };
    }
}
