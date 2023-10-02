package com.wade.springbootexample.service;

import com.wade.springbootexample.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);
}
