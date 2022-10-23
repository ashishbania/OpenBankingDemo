package com.example.demo.OpenBankingDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.OpenBankingDemo"})
public class OpenBankingDemo {

	public static void main(String[] args) {
		SpringApplication.run(OpenBankingDemo.class, args);
		}

}
