package com.firstapp.firstappbackend.service.impl;

import com.firstapp.firstappbackend.common.ResponseCode;
import com.firstapp.firstappbackend.dao.UserMapper;
import com.firstapp.firstappbackend.pojo.User;
import com.firstapp.firstappbackend.service.IUserService;
import com.firstapp.firstappbackend.utils.DateUtil;
import com.firstapp.firstappbackend.utils.MD5Utils;
import com.firstapp.firstappbackend.utils.ServerResponse;
import com.firstapp.firstappbackend.vo.UserVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 完成登录的业务逻辑
 * */
@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public ServerResponse loginLogic(String username, String password) {

            //写业务逻辑
        /**
         * 1.用户名和密码的非空判断
         * 2.查看用户是否存在
         * 3.根据用户名和密码查询
         * 4.返回结果
         * */
        //1.判空
        if (StringUtils.isBlank(username)){
            return  ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EMPTY.getCode(),ResponseCode.USERNAME_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(password)){
            return  ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_NOT_EMPTY.getCode(),ResponseCode.PASSWORD_NOT_EMPTY.getMsg());
        }
        //2.判用户名是否存在
        Integer count=userMapper.fingByUsername(username);
        if (count==0){
            return  ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EXISTS.getCode(),ResponseCode.USERNAME_NOT_EXISTS.getMsg());
        }
        //用户名和密码去查询
        User user=userMapper.findByUsernameAndPassword(username,MD5Utils.getMD5Code(password));
        if (user==null){
            return ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_NOT_Right.getCode(),ResponseCode.PASSWORD_NOT_Right.getMsg());
        }
        // 返回结果  返回userVo
        return  ServerResponse.createServerResponseBySuccess(convert(user));
    }
    private UserVO convert(User user){
        UserVO userVO=new UserVO();
        userVO.setId(user.getId());
        userVO.setUserName(user.getUserName());
        userVO.setCreateTime(DateUtil.dataToString( user.getCreateTime()));
        userVO.setUpdateTime(DateUtil.dataToString(user.getUpdateTime()));
        return  userVO;
    }
    @Override
    public ServerResponse signupLogic(User user) {
        if (user==null){
         return  ServerResponse.createServerResponseByFail(ResponseCode.PARAMTER_NOT_EMPTY.getCode(),ResponseCode.PASSWORD_NOT_Right.getMsg());
        }
        String username=user.getUserName();
        String password=user.getPassword();
        String question=user.getQuestion();
        String answer=user.getAnswer();
        //1.判空
        //用户名不能为空
        if (StringUtils.isBlank(username)){
            return  ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EMPTY.getCode(),ResponseCode.USERNAME_NOT_EMPTY.getMsg());
        }
        //密码不能为空
        if (StringUtils.isBlank(password)){
            return  ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_NOT_EMPTY.getCode(),ResponseCode.PASSWORD_NOT_EMPTY.getMsg());
        }
        //密保问题和答案不能为空
        if (StringUtils.isBlank(question)){
            return  ServerResponse.createServerResponseByFail(ResponseCode.QUESTION_NOT_EMPTY.getCode(),ResponseCode.QUESTION_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(answer)){
            return  ServerResponse.createServerResponseByFail(ResponseCode.ANSWER_NOT_EMPTY.getCode(),ResponseCode.ANSWER_NOT_EMPTY.getMsg());
        }

        //2.判断用户名是否存在
        Integer count=userMapper.fingByUsername(username);
        if (count>0){
            return  ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_EXITS.getCode(),ResponseCode.USERNAME_EXITS.getMsg());
        }
        //3.执行注册
            //密码加密
        user.setPassword(MD5Utils.getMD5Code(user.getPassword()));
            //注册
       Integer result= userMapper.insert(user);
       if (result==0){
                //注册失败
           return  ServerResponse.createServerResponseByFail(ResponseCode.SIGNUP_FAIL.getCode(),ResponseCode.SIGNUP_FAIL.getMsg());
       }
            //注册成功
            return  ServerResponse.createServerResponseBySuccess();
    }
}
