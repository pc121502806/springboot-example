package com.wade.springbootexample.service.impl;

import com.wade.springbootexample.dao.OrderDao;
import com.wade.springbootexample.dao.ProductDao;
import com.wade.springbootexample.dto.BuyItem;
import com.wade.springbootexample.dto.CreateOrderRequest;
import com.wade.springbootexample.model.OrderItem;
import com.wade.springbootexample.model.Product;
import com.wade.springbootexample.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());

            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount += amount;

            // transform BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        // Create Order
        Integer orderId = orderDao.CreateOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }
}
