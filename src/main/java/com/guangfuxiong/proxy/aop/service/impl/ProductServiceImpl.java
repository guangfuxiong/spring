package com.guangfuxiong.proxy.aop.service.impl;

import com.guangfuxiong.proxy.aop.anno.Hello;
import com.guangfuxiong.proxy.aop.anno.Transaction;
import com.guangfuxiong.proxy.aop.dao.ProductDao;
import com.guangfuxiong.proxy.aop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    @Hello
    public void addProduct() {
        productDao.addPro();
        //int a = 1/0;
    }

    @Override
    public void updateProduct() {
        productDao.updatePro();
    }
}
