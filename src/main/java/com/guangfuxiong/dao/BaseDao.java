package com.guangfuxiong.dao;

import com.guangfuxiong.bd.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao {
    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
