package com.example.demo.OpenBankingDemo;

import com.example.demo.OpenBankingDemo.aysnc.CountryClient;
import com.example.demo.OpenBankingDemo.aysnc.CountryResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.OpenBankingDemo"}, excludeFilters = {@ComponentScan.Filter(
		type = FilterType.ASSIGNABLE_TYPE, classes = {CountryClient.class, CountryResource.class}
)})
public class OpenBankingDemo {

	public static void main(String[] args) {
		SpringApplication.run(OpenBankingDemo.class, args);
		}

}
