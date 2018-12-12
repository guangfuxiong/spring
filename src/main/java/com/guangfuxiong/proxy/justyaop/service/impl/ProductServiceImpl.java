package com.guangfuxiong.proxy.justyaop.service.impl;


import com.guangfuxiong.proxy.justyaop.anno.PrivilegeInfo;
import com.guangfuxiong.proxy.justyaop.dao.ProductDao;
import com.guangfuxiong.proxy.justyaop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    @PrivilegeInfo(name="delete")
    public void addProduct() {
        productDao.addPro();
        //int a = 1/0;
    }

    @Override
    @PrivilegeInfo(name="update")
    public void updateProduct() {
        productDao.updatePro();
    }
}
