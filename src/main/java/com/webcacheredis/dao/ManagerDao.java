package com.webcacheredis.dao;

import com.webcacheredis.bean.Manager;

import java.util.List;

public interface ManagerDao {

    void addManager(Manager manager);
    /**
     * 医院管理员
     * @return 数量
     */
    public List<Manager> listManager();
    public Manager findManagerById(Integer oid);
    public void updateManager(Manager manager);
}
