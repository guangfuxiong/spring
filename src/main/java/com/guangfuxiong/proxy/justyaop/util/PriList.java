package com.guangfuxiong.proxy.justyaop.util;

import java.util.List;

/**
 * 用户权限列表
 */
public class PriList {
    private static List<String> priList = null;
    public static List<String> getPriList(){
        return priList;
    }
    public static List<String> setPriList(List<String> list){
        return priList=list;
    }
}
