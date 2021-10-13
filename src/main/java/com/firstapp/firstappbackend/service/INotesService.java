package com.firstapp.firstappbackend.service;

import com.firstapp.firstappbackend.pojo.Notes;
import com.firstapp.firstappbackend.pojo.User;
import com.firstapp.firstappbackend.utils.ServerResponse;

public interface INotesService {

    /**
     * 登录
     * */
   //
    public ServerResponse  createLogic(Notes notes,Integer userId);
    public  ServerResponse  updateLogic(Notes notes,Integer userId);
    public  ServerResponse  deleteLogic(String title,Integer userId);
}
