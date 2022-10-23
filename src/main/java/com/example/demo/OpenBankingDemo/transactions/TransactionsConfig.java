package com.example.demo.OpenBankingDemo.transactions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TransactionsConfig {
    @Bean
    CommandLineRunner commandLineRunnerTransactionsRR(TransactionsRepository transactionsRepository) {
        return args -> {
            Transactions transactions1 = new Transactions(
                    1, 1, "5048375892149526", "$789.81", "USD", "Debit", "Rejected", "02/24/2022", "Persevering static standardization"
            );

            Transactions transactions2 = new Transactions(
                    2, 2, "5108752683825620", "$346.01", "USD", "Credit", "Rejected", " 06/07/2022 ", " Diverse 24/7 intranet ");
            transactionsRepository.saveAll(Arrays.asList(transactions1, transactions2));
        };
    }
}
