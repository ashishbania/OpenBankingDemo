package com.example.demo.OpenBankingDemo.order.model;

import javax.persistence.*;

@Entity
@Table
public class OrderCart {
    @Id
    @SequenceGenerator(name = "order_sequence",sequenceName = "order_sequence", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    private Long orderNumber;
    private String orderItem;
    private String orderDetails;
    //empty constructor

    public OrderCart() {
    }

    //constructor without orderNumber field
    public OrderCart(String orderItem, String orderDetails) {
        this.orderItem = orderItem;
        this.orderDetails = orderDetails;
    }

    //Constructor with all the fields

    public OrderCart(Long orderNumber, String orderItem, String orderDetails) {
        this.orderNumber = orderNumber;
        this.orderItem = orderItem;
        this.orderDetails = orderDetails;
    }

    //Getters and Setters

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    //toString

    @Override
    public String toString() {
        return "order{" +
                "orderNumber=" + orderNumber +
                ", orderItem='" + orderItem + '\'' +
                ", OrderDetails='" + orderDetails + '\'' +
                '}';
    }
}
