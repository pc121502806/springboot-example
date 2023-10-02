package com.wade.springbootexample.service.impl;

import com.wade.springbootexample.dao.ProductDao;
import com.wade.springbootexample.dto.ProductRequest;
import com.wade.springbootexample.model.Product;
import com.wade.springbootexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }
}
