package com.webcacheredis.controller;

import com.webcacheredis.bean.Manager;
import com.webcacheredis.bean.ResponseBean;
import com.webcacheredis.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "hello.do", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String hello(){
        return "springMVC 配置成功！";
    }

    @RequestMapping(value="/addManager.do")
    @ResponseBody
    public ResponseBean addManager(Manager manager){
        ResponseBean rb = new ResponseBean();
        try {
            managerService.addManager(manager);
        } catch (Exception e) {
            rb.setStatus(0);
            e.printStackTrace();
        }
        return rb;
    }

    @RequestMapping(value="/listManager.do")
    @ResponseBody
    public ResponseBean listmanager(){
        ResponseBean rb = new ResponseBean();
        try {
            rb.setObject(managerService.listManager());
        } catch (Exception e) {
            rb.setStatus(0);
            e.printStackTrace();
        }
        return rb;
    }
}
