package com.redis;

public class RetResult {
    private String msg;
    private String success;
    private Object object;

    @Override
    public String toString() {
        return "RetResult{" +
                "msg='" + msg + '\'' +
                ", success='" + success + '\'' +
                ", object=" + object +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
