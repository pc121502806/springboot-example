package com.wade.springbootexample.service;

import com.wade.springbootexample.dto.CreateOrderRequest;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
