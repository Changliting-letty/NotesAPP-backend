package com.firstapp.firstappbackend.utils;

//接口向前端返回

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *封装前端返回到饿统一实体类
 */

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL) //只返回非空字段
public class ServerResponse <T>{

    private  int status;  //0表成功，1表失败
    private  T data;  //status为0时，将返回的书记封装到data
    private  String msg;  //提示信息


    //封装

    private ServerResponse() {
    }

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }
    @JsonIgnore
    public   boolean isSuccess(){
        return   this.status==0;
    }
    public  static ServerResponse createServerResponseBySuccess(){
        return  new ServerResponse(0);
    }
    public  static <T> ServerResponse createServerResponseBySuccess(T data){
        return  new ServerResponse(0,data);
    }

    public  static <T> ServerResponse createServerResponseBySuccess(T data,String msg){
        return  new ServerResponse(0,data,msg);
    }
    public  static ServerResponse createServerResponseByFail(int status){
        return  new ServerResponse(status);
    }
    public  static ServerResponse createServerResponseByFail(int status,String msg){
        return  new ServerResponse(status,null,msg);
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
}
