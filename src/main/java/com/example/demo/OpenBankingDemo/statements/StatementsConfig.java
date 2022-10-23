package com.example.demo.OpenBankingDemo.statements;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class StatementsConfig {
    @Bean
    CommandLineRunner commandLineRunnerStatements(StatementsRepository statementsRepository) {
        return args -> {
            Statements statements1 = new Statements(
                    1, 1, "5048375892149526", "$789.81", "USD", "Debit", "Rejected", "02/24/2022", "Persevering static standardization"
            );

            Statements statements2 = new Statements(
                    2, 2, "5108752683825620", "$346.01", "USD", "Credit", "Rejected", " 06/07/2022 ", " Diverse 24/7 intranet ");
            statementsRepository.saveAll(Arrays.asList(statements1, statements2));
        };
    }
}
