package com.firstapp.firstappbackend.service;

import com.firstapp.firstappbackend.pojo.Notes;
import com.firstapp.firstappbackend.pojo.User;
import com.firstapp.firstappbackend.utils.ServerResponse;
import com.firstapp.firstappbackend.vo.NotesVO;

import javax.servlet.http.HttpSession;

public interface INotesService {

    /**
     * 登录
     */
    //
    public ServerResponse createLogic(NotesVO notesVO, Integer userId);

    public ServerResponse updateLogic(Integer onlineId, NotesVO notesVO, Integer userId);

    public ServerResponse deleteLogic(Integer onlineId, Integer userId);

    public ServerResponse getNotesList(String userName);
}
