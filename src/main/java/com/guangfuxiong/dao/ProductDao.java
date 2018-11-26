package com.guangfuxiong.dao;

import com.guangfuxiong.bd.DataSource;

public class ProductDao extends BaseDao{
    /*DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/
    public void addProduct(){
        dataSource.getConn();
        System.out.println("添加用户成功");
        dataSource.closeConn();
    }
}
