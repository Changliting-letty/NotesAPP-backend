package com.firstapp.firstappbackend.service;

import com.firstapp.firstappbackend.common.Const;
import com.firstapp.firstappbackend.pojo.Notes;
import com.firstapp.firstappbackend.pojo.User;
import com.firstapp.firstappbackend.utils.ServerResponse;
import com.firstapp.firstappbackend.vo.NotesVO;
<<<<<<< HEAD

import javax.servlet.http.HttpSession;
=======
import com.firstapp.firstappbackend.vo.ResponseVO;
import com.firstapp.firstappbackend.vo.UserVO;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
>>>>>>> main-2.0

public interface INotesService {

    /**
     * 登录
     */
    //
    public ServerResponse createLogic(NotesVO notesVO, Integer userId);

    public ServerResponse updateLogic(Integer onlineId, NotesVO notesVO, Integer userId);

    public ServerResponse deleteLogic(Integer onlineId, Integer userId);

<<<<<<< HEAD
    public ServerResponse getNotesList(String userName);
=======
    public ServerResponse getNotesList(Integer userId);

    public ServerResponse handleSyn(Integer userId, String lastSynTime, List<ResponseVO> list);
>>>>>>> main-2.0
}
