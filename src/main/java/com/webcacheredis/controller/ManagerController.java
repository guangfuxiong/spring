package com.webcacheredis.controller;

import com.alibaba.fastjson.JSON;
import com.webcacheredis.bean.Manager;
import com.webcacheredis.bean.ResponseBean;
import com.webcacheredis.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "hello.do", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String hello() {
        return "springMVC 配置成功！";
    }

    @RequestMapping(value = "/addManager.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseBean addManager(@RequestBody Map<String, Object> map) {
        //Manager manager = JSON.parseObject(JSON.toJSONString(map),Manager.class);
        Manager manager = new Manager();
        manager.setOid((Integer) map.get("oid"));
        manager.setUsername((String) map.get("username"));
        manager.setPassword(Integer.toString((Integer) map.get("password")));
        manager.setHid((Integer) map.get("hid"));
        manager.setType((String) map.get("type"));
        manager.setState((String) map.get("state"));
        ResponseBean rb = new ResponseBean();
        try {
            managerService.addManager(manager);
            managerService.fushall();//由于redis的特殊性，只能删除键值对，所以每次更新换添加操作都要清空所有的缓存
        } catch (Exception e) {
            rb.setStatus(0);
            e.printStackTrace();
        }
        return rb;
    }

    @RequestMapping(value = "/listManager.do")
    @ResponseBody
    public ResponseBean listmanager() {
        ResponseBean rb = new ResponseBean();
        try {
            rb.setObject(managerService.listManager());
        } catch (Exception e) {
            rb.setStatus(0);
            e.printStackTrace();
        }
        return rb;
    }

    @RequestMapping(value = "/findManagerById.do")
    @ResponseBody
    public ResponseBean findManagerById(Integer oid) {
        ResponseBean rb = new ResponseBean();
        try {
            rb.setObject(managerService.findManagerById(oid));
        } catch (Exception e) {
            rb.setStatus(0);
            e.printStackTrace();
        }
        return rb;
    }

    @RequestMapping(value = "/updateManager.do")
    @ResponseBody
    public ResponseBean updateManager(@RequestBody Manager manager) {
        ResponseBean rb = new ResponseBean();
        try {
            managerService.updateManager(manager);
            managerService.fushall();//由于redis的特殊性，只能删除键值对，所以每次更新操作所有都要清空所有的缓存
        } catch (Exception e) {
            rb.setStatus(0);
            e.printStackTrace();
        }
        return rb;
    }

    /**
     * 缓存主页
     */
    @RequestMapping(value = "listmanagers.do")
    public String listmanagers(Model model){
        List<Manager> listmanager = new ArrayList<>();
        try {
            listmanager = managerService.listManager();
           model.addAttribute("listmanager",listmanager);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("*****************下次缓存页面*****************");
        return "catchpage/listmanager";
    }
}