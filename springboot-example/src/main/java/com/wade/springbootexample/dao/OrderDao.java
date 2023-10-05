package com.wade.springbootexample.dao;

import com.wade.springbootexample.dto.OrderQueryParams;
import com.wade.springbootexample.model.Order;
import com.wade.springbootexample.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer countOrder(OrderQueryParams orderQueryParams);
    List<Order> getOrders(OrderQueryParams orderQueryParams);
    Order getOrderById(Integer orderId);
    List<OrderItem> getOrderItemsByOrderId(Integer orderId);
    Integer CreateOrder(Integer userId, int totalAmount);
    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);

}
