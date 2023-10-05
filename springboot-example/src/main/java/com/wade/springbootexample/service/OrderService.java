package com.wade.springbootexample.service;

import com.wade.springbootexample.dto.CreateOrderRequest;
import com.wade.springbootexample.dto.OrderQueryParams;
import com.wade.springbootexample.model.Order;

import java.util.List;

public interface OrderService {
    Integer countOrder(OrderQueryParams orderQueryParams);
    List<Order> getOrders(OrderQueryParams orderQueryParams);
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
