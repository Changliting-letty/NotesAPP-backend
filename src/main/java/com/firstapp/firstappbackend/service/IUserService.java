package com.firstapp.firstappbackend.service;

import com.firstapp.firstappbackend.pojo.User;
import com.firstapp.firstappbackend.utils.ServerResponse;

public interface IUserService {

    /**
     * 登录
     * */

    public ServerResponse loginLogic(String username,String password);

    public  ServerResponse signupLogic(User user);


}
