package com.wade.springbootexample.dao;

import com.wade.springbootexample.dto.ProductRequest;
import com.wade.springbootexample.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
