package com.wade.springbootexample.dao;

import com.wade.springbootexample.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
