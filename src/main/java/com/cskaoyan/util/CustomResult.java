package com.cskaoyan.util;


import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义相应结构
 */
public class CustomResult {

    //定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //响应业务状态
    private Integer status;

    //响应消息
    private String msg;

    //响应中的数据
    private Object data;

    public CustomResult(){}

    //如果查询到数据，一般就返回ok
    public CustomResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public CustomResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }


    public static CustomResult ok(){
        return new CustomResult(null);
    }

    public static CustomResult ok(Object data){
        return new CustomResult(data);
    }

    public static CustomResult build(Integer status, String msg) {
        return new CustomResult(status, msg, null);
    }

    public static CustomResult build(Integer status, String msg, Object data) {
        return new CustomResult(status, msg, data);
    }






    public static ObjectMapper getMAPPER() {
        return MAPPER;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
