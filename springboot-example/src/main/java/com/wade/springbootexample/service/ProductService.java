package com.wade.springbootexample.service;

import com.wade.springbootexample.dto.ProductRequest;
import com.wade.springbootexample.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
