package com.webcacheredis.bean;

import java.io.Serializable;

public class ResponseBean implements Serializable{
    private Integer status = 200;
    private Object object;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "status=" + status +
                ", object=" + object +
                '}';
    }
}
