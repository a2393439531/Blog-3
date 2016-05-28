package com.scau.entity;

/**
 * @Author: beyondboy
 * @Gmail: xuguoli.scau@gamil.com
 * @Data: 2016/5/25
 * @Time: 23:32
 * 响应实体对象
 */
public class ResponseObject {
    private int state;
    private String msg;
    private Object data;

    public ResponseObject(int state, String msg, Object data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }
    public ResponseObject(int state, String msg) {
        this(state,msg,null);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
