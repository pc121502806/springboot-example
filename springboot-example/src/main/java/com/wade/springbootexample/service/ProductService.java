package com.wade.springbootexample.service;

import com.wade.springbootexample.dto.ProductRequest;
import com.wade.springbootexample.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
