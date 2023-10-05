package com.wade.springbootexample.service.impl;

import com.wade.springbootexample.dao.OrderDao;
import com.wade.springbootexample.dao.ProductDao;
import com.wade.springbootexample.dao.UserDao;
import com.wade.springbootexample.dto.BuyItem;
import com.wade.springbootexample.dto.CreateOrderRequest;
import com.wade.springbootexample.model.Order;
import com.wade.springbootexample.model.OrderItem;
import com.wade.springbootexample.model.Product;
import com.wade.springbootexample.model.User;
import com.wade.springbootexample.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    private final static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDao userDao;

    @Override
    public Order getOrderById(Integer orderId) {

        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        // Check user exist
        User user = userDao.getUserById(userId);

        if (user == null){
            log.warn("This userId {} not exist", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());

            // Check product exist and stock
            if (product == null){
                log.warn("This product {} not exist", buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            } else if (product.getStock() < buyItem.getQuantity()) {
                log.warn("This product {} stock not enough, Remain number: {}, buy number: {}",
                        buyItem.getProductId(), product.getStock(), buyItem.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            // subtract product stock
            productDao.updateStock(product.getProductId(), product.getStock() - buyItem.getQuantity());

            // Calculate amount
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
