package com.example.demo.OpenBankingDemo.order.service;

import com.example.demo.OpenBankingDemo.order.model.OrderCart;
import com.example.demo.OpenBankingDemo.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<OrderCart> fetchOrder(){
        return orderRepository.findAll();
    }

    public void addNewOrder(OrderCart orderCart){
        if(orderRepository.findOrderByDetails(orderCart.getOrderDetails()).isPresent()){
            throw new IllegalStateException("Order is already present");
        }
        orderRepository.save(orderCart);
    }

    public void deleteOrder(Long orderNumber) {
        if(!orderRepository.findById(orderNumber).isPresent()){
            throw new IllegalStateException("Order is not present");
        }
        orderRepository.deleteById(orderNumber);
    }
}
