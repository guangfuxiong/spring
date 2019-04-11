package com.webcacheredis.service.impl;

import com.webcacheredis.bean.Manager;
import com.webcacheredis.dao.ManagerDao;
import com.webcacheredis.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;

    @Override
    public void addManager(Manager manager) {
        managerDao.addManager(manager);
    }

    @Override
    public List<Manager> listManager() {
        return managerDao.listManager();
    }
}
