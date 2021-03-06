package com.firstapp.firstappbackend.inteceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstapp.firstappbackend.common.Const;
import com.firstapp.firstappbackend.common.ResponseCode;
import com.firstapp.firstappbackend.utils.ServerResponse;
import com.firstapp.firstappbackend.vo.UserVO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class PortalLoginCheckInterceptor implements HandlerInterceptor {


    /**
     * 在请求到达controller之前
     *
     * @return true:不拦截请求 false:拦截请求
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        System.out.println("=======preHandle======");

        HttpSession session = request.getSession();
        UserVO userVO = (UserVO) session.getAttribute(Const.CURRENT_USER);
        if (userVO != null) {
            //已经登录
            return true;
        }

        //用户未登录，重写Response
        //向前端返回response提示未登录，通过输出流
        try {
            response.reset();
            response.addHeader("Content-Type", "application/json;charset=utf-8");
            PrintWriter printWriter = response.getWriter();
<<<<<<< HEAD
            ServerResponse serverResponse = ServerResponse.createServerResponseByFail(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getMsg());
=======
            ServerResponse serverResponse = ServerResponse.createServerResponseByFail(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getMsg(), -1);
>>>>>>> main-2.0
            ObjectMapper objectMapper = new ObjectMapper();
            String info = objectMapper.writeValueAsString(serverResponse);
            printWriter.write(info);
            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }

    //在请求处理完成后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("=======postHandle======");
    }

    //客户端接收到响应后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        System.out.println("=======afterCompletion======");
    }
}