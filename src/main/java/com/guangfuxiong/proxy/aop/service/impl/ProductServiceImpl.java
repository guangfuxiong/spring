package com.guangfuxiong.proxy.aop.service.impl;

import com.guangfuxiong.proxy.aop.service.ProductService;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Override
    public void addProduct() {
        System.out.println("添加商品");
    }
}
