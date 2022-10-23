package com.example.demo.OpenBankingDemo.order.controller;

import com.example.demo.OpenBankingDemo.order.model.OrderCart;
import com.example.demo.OpenBankingDemo.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/order")

public class OrderController {

    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderCart> getOrder(){
        return orderService.fetchOrder();
    }

    @PostMapping
    public void addNewOrderCart(@RequestBody OrderCart orderCart  ){
        orderService.addNewOrder(orderCart);
    }

    @DeleteMapping(path = "{orderNumber}")
    public void deleteOrder(@PathVariable("orderNumber") Long orderNumber){
        orderService.deleteOrder(orderNumber);
    }
}
