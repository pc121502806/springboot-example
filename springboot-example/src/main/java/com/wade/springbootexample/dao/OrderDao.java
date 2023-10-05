package com.wade.springbootexample.dao;

import com.wade.springbootexample.model.OrderItem;

import java.util.List;

public interface OrderDao {
    Integer CreateOrder(Integer userId, int totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
