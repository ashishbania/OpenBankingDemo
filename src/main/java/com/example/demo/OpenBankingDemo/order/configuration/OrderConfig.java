package com.example.demo.OpenBankingDemo.order.configuration;

import com.example.demo.OpenBankingDemo.order.model.OrderCart;
import com.example.demo.OpenBankingDemo.order.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OrderConfig {
    @Bean
    CommandLineRunner commandLineRunnerOrder(OrderRepository orderRepository){
        return args -> {
            OrderCart orderCart1 = new OrderCart(
                    1L,
                    "Shirt",
                    "blue in color"
            );
            OrderCart orderCart2 = new OrderCart(
                    2L,
                    "Pant",
                    "white in color"
            );
            orderRepository.saveAll(Arrays.asList(orderCart1, orderCart2));
        };
    }
}
