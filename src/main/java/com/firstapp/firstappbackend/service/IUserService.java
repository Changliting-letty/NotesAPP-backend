package com.firstapp.firstappbackend.service;

import com.firstapp.firstappbackend.pojo.User;
import com.firstapp.firstappbackend.utils.ServerResponse;

import javax.servlet.http.HttpSession;

public interface IUserService {

    /**
     * 登录
     */

    public ServerResponse loginLogic(String username, String password);

    public ServerResponse signupLogic(User user);

<<<<<<< HEAD
    public ServerResponse logoutLogin(HttpSession session);
=======
    public ServerResponse logoutLogin(HttpSession session, Integer userId);
>>>>>>> main-2.0

}
