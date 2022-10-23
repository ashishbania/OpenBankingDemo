package com.example.demo.OpenBankingDemo.order.repository;

import com.example.demo.OpenBankingDemo.order.model.OrderCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderCart, Long> {

    @Query("SELECT o FROM OrderCart o WHERE o.orderDetails=?1")
    Optional<OrderCart> findOrderByDetails(String orderdetails);
}
