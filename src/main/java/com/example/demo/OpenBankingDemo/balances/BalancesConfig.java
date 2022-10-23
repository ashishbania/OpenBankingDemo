package com.example.demo.OpenBankingDemo.balances;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class BalancesConfig {
    @Bean
    CommandLineRunner commandLineRunnerBalances(BalancesRepository balancesRepository) {
        return args -> {
            Balances balances1 = new Balances(
                    1, 1, "5048375892149526", "$789.81", "USD", "Debit", "Rejected", "02/24/2022", "Persevering static standardization"
            );

            Balances balances2 = new Balances(
                    2, 2, "5108752683825620", "$346.01", "USD", "Credit", "Rejected", " 06/07/2022 ", " Diverse 24/7 intranet ");
            balancesRepository.saveAll(Arrays.asList(balances1, balances2));
        };
    }
}
