package com.firstapp.firstappbackend.vo;

import org.apache.shiro.authc.AuthenticationToken;

public class JWTToken implements AuthenticationToken {

    private String token;
    //登录类型，区分PC端和移动端 1PC，2App
    private String loginType;

    public JWTToken(String token, String loginType) {
        this.token = token;
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
