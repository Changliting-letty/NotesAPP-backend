package com.firstapp.firstappbackend.common;

public enum ResponseCode {

    //状态码管理
    IS_SIGNUP_SUCCESS(0, "注册成功"),
    IS_LOGIN_SUCCESS(0, "登录成功"),
    IS_CREATENOTE_SUCCESS(0, "Notes创建成功"),
    IS_UPDATENOTE_SUCCESS(0, "Notes创建成功"),
    IS_SEARCHNOTE_SUCCESS(0, "Notes创建成功"),
    IS_DELETE_SUCCESS(0, "Notes创建成功"),
    NOTE_NOT_EXISTS(1, "用户还未创建任何Note"),
    USERNAME_NOT_EMPTY(2, "用户名不能为空"),
    PASSWORD_NOT_EMPTY(3, "密码不能为空"),
    USERNAME_NOT_EXISTS(4, "用户名不存在"),
    PASSWORD_NOT_Right(5, "密码错误"),
    PARAMTER_NOT_EMPTY(6, "参数不能为空"),
    USERNAME_EXITS(7, "用户名存在"),
    SIGNUP_FAIL(8, "注册失败"),
    NEED_LOGIN(9, "用户需要登录"),
    NOTE_NOT_EMPTY(10, "Note不能为空"),
    CREATENOTE_FALI(11, "Note新建失败"),
    UPDATENOTE_FAIL(12, "Note修改失败"),
    DELETENOTE_FAIL(13, "Notes删除失败"),
    IS_LOGOUT_SUCCESS(0, "退出成功");
    private int code;
    private String msg;

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
