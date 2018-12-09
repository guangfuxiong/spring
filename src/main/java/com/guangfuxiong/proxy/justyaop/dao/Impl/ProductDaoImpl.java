package com.guangfuxiong.proxy.justyaop.dao.Impl;

import com.guangfuxiong.proxy.justyaop.dao.ProductDao;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Override
    public void addPro() {
        System.out.println("添加商品");
    }

    @Override
    public void updatePro() {
        System.out.println("修改商品");
    }
}
