package com.webcacheredis.service;

import com.webcacheredis.bean.Manager;
import com.webcacheredis.dao.ManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ManagerService {
    void addManager(Manager manager);
    public List<Manager> listManager();
    Manager findManagerById(Integer oid);
    void updateManager(Manager manager);
}
