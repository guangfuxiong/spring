package com.webcacheredis.service.impl;

import com.webcacheredis.bean.Manager;
import com.webcacheredis.dao.ManagerDao;
import com.webcacheredis.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "manager")
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;

    @Override
    @CacheEvict(value = "managerInfo",key = "'id_'+#manager.oid")
    public void addManager(Manager manager) {
        managerDao.addManager(manager);
    }

    @Override
    @Cacheable(value = "managerInfo",key = "'list'")
    public List<Manager> listManager() {
        return managerDao.listManager();
    }

    @Override
    @Cacheable(value = "managerInfo",key="'id_'+#oid")
    public Manager findManagerById(Integer oid) {
        return managerDao.findManagerById(oid);
    }

    @Override
    @CacheEvict (value = "managerInfo",key="'id_'+#manager.oid")
    public void updateManager(Manager manager) {
        managerDao.updateManager(manager);
    }

    @Override
    @CacheEvict (value = "managerInfo",key="'list'")
    public void fushall() {
        System.out.println("************************清除缓存*******************************");
    }
}
