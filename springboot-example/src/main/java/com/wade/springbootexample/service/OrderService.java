package com.wade.springbootexample.service;

import com.wade.springbootexample.dto.CreateOrderRequest;
import com.wade.springbootexample.model.Order;

public interface OrderService {
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
