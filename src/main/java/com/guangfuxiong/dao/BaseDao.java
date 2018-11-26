package com.guangfuxiong.dao;

import com.guangfuxiong.bd.DataSource;

public class BaseDao {
    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
