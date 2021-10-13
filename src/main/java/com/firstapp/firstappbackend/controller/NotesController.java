package com.firstapp.firstappbackend.controller;


import com.firstapp.firstappbackend.common.Const;
import com.firstapp.firstappbackend.pojo.Notes;
import com.firstapp.firstappbackend.pojo.User;
import com.firstapp.firstappbackend.service.impl.NotesService;
import com.firstapp.firstappbackend.utils.ServerResponse;
import com.firstapp.firstappbackend.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/portal/notes/")
public class NotesController {
    /**
     * 新增notes
     * */
    @Autowired
    NotesService notesService;

    @RequestMapping(value = "addNote.do")
    public ServerResponse addNote(Notes notes, HttpServletRequest request){
        UserVO uservo=(UserVO)request.getSession().getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse=notesService.createLogic(notes,uservo.getId());
            return  serverResponse;
    }
    @RequestMapping(value = "updateNote.do")
    public ServerResponse updateNote(Notes notes,HttpServletRequest request){
        UserVO uservo=(UserVO)request.getSession().getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse=notesService.updateLogic(notes,uservo.getId());
        return  serverResponse;
    }

    @RequestMapping(value = "deleteNote.do")
    public ServerResponse deleteNote(Notes notes,HttpServletRequest request){

        UserVO uservo=(UserVO)request.getSession().getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse=notesService.deleteLogic(notes,uservo.getId());
        return  serverResponse;
    }

}
