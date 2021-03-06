package com.firstapp.firstappbackend.utils;

//接口向前端返回

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.firstapp.firstappbackend.common.ResponseCode;

import java.util.Date;

/**
<<<<<<< HEAD
 * 封装前端返回到饿统一实体类
=======
 * 封装前端返回到统一实体类
>>>>>>> main-2.0
 */

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL) //只返回非空字段
public class ServerResponse<T> {

    private int status;  //0表成功，1表失败
    private T data;  //status为0时，将返回的数据封装到data
    private String msg;  //提示信息
    private int userId;
<<<<<<< HEAD
=======
    private String timeNow;
>>>>>>> main-2.0

    //封装
    private ServerResponse() {
    }

    private ServerResponse(int status, int userId) {
        this.status = status;
        timeNow = DateUtil.dataToString(new Date());
        this.userId = userId;
    }

    private ServerResponse(int status) {
        this.status = status;
        timeNow = DateUtil.dataToString(new Date());
    }

    private ServerResponse(int status, T data, int userId) {
        this.status = status;
        this.data = data;
        this.userId = userId;
        timeNow = DateUtil.dataToString(new Date());
    }

    private ServerResponse(int status, T data, String msg, int userId) {
        this.status = status;
        this.data = data;
        this.msg = msg;
        this.userId = userId;
        timeNow = DateUtil.dataToString(new Date());
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.status == 0;
<<<<<<< HEAD
    }

    public static ServerResponse createServerResponseBySuccess() {
        return new ServerResponse(0);
    }

    public static ServerResponse createServerResponseBySuccess(int status, String msg) {
        return new ServerResponse(status, null, msg);
    }

    public static <T> ServerResponse createServerResponseBySuccess(T data) {
        return new ServerResponse(0, data);
    }


    public static <T> ServerResponse createServerResponseBySuccess(int code, T data, String msg) {
        return new ServerResponse(code, data, msg);
    }

    public static ServerResponse createServerResponseByFail(int status) {
        return new ServerResponse(status);
    }

    public static ServerResponse createServerResponseByFail(int status, String msg) {
        return new ServerResponse(status, null, msg);
=======
    }

    public static ServerResponse createServerResponseBySuccess() {
        return new ServerResponse(0);
    }

    public static ServerResponse createServerResponseBySuccess(int status, String msg, int userId) {
        return new ServerResponse(status, null, msg, userId);
    }

    public static <T> ServerResponse createServerResponseBySuccess(T data, int userId) {
        return new ServerResponse(0, data, userId);
    }


    public static <T> ServerResponse createServerResponseBySuccess(int code, T data, String msg, int userId) {
        return new ServerResponse(code, data, msg, userId);
    }

    public static ServerResponse createServerResponseByFail(int status, int userId) {
        return new ServerResponse(status, userId);
    }

    public static ServerResponse createServerResponseByFail(int status, String msg, int userId) {
        return new ServerResponse(status, null, msg, userId);
>>>>>>> main-2.0
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTimeNow() {
        return timeNow;
    }

    public void setTimeNow(String timeNow) {
        this.timeNow = timeNow;
    }
}
