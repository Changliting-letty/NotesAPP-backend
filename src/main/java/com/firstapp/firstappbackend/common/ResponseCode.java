package com.firstapp.firstappbackend.common;

public enum ResponseCode {

 //状态码管理
    USERNAME_NOT_EMPTY(1,"用户名不能为空"),
    PASSWORD_NOT_EMPTY(2,"密码不能为空"),
    USERNAME_NOT_EXISTS(3,"用户名不存在"),
    PASSWORD_NOT_Right(4,"密码错误"),
    PARAMTER_NOT_EMPTY(5,"参数不能为空"),
    USERNAME_EXITS(6,"用户名存在"),
    SIGNUP_FAIL(7,"注册失败"),
    Need_LOGIN(8,"用户需要登录")
    ;
    private  int code;
    private  String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
