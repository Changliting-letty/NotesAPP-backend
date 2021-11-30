package com.firstapp.firstappbackend.controller;

import com.firstapp.firstappbackend.common.Const;
import com.firstapp.firstappbackend.pojo.User;
import com.firstapp.firstappbackend.service.IUserService;
import com.firstapp.firstappbackend.utils.ServerResponse;
import com.firstapp.firstappbackend.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
//使其称为一个控制器的类
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/portal/user/login.do")
    public ServerResponse login(String username, String password, HttpServletRequest request) {
        //从库里查
        ServerResponse serverResponse = userService.loginLogic(username, password);
        //登录成功放到Session
        if (serverResponse.isSuccess()) {
            request.getSession().setAttribute(Const.CURRENT_USER, serverResponse.getData());
            //其他模块可借此判断用户是否登录
        }
        return serverResponse;
    }

    @RequestMapping(value = "/portal/user/signup.do")
    public ServerResponse signup(User user) {
        ServerResponse serverResponse = userService.signupLogic(user);
        return serverResponse;
    }

    @RequestMapping(value = "/portal/user/logout.do")
    public ServerResponse logout(HttpServletRequest request) {
        UserVO uservo = (UserVO) request.getSession().getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse = userService.logoutLogin(request.getSession(),uservo.getUserId());
        return serverResponse;
    }

}
