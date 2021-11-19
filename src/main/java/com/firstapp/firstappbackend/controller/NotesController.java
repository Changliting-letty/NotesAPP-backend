package com.firstapp.firstappbackend.controller;

import com.firstapp.firstappbackend.common.Const;
import com.firstapp.firstappbackend.pojo.Notes;
import com.firstapp.firstappbackend.service.impl.NotesService;
import com.firstapp.firstappbackend.utils.ServerResponse;
import com.firstapp.firstappbackend.vo.NotesVO;
import com.firstapp.firstappbackend.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/portal/notes/")
public class NotesController {
    /**
     * 新增notes
     */
    @Autowired
    NotesService notesService;

    @RequestMapping(value = "addNote.do", method = RequestMethod.POST)
    public ServerResponse addNote(@RequestBody NotesVO notesvo, HttpServletRequest request) {
        UserVO uservo = (UserVO) request.getSession().getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse = notesService.createLogic(notesvo, uservo.getUserId());
        return serverResponse;
    }

    @RequestMapping(value = "updateNote.do", method = RequestMethod.POST)
    public ServerResponse updateNote(@RequestParam(value = "onlineId") Integer onlineId, @RequestBody NotesVO notesVO, HttpServletRequest request) {
        UserVO uservo = (UserVO) request.getSession().getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse = notesService.updateLogic(onlineId, notesVO, uservo.getUserId());
        return serverResponse;
    }

    @RequestMapping(value = "deleteNote.do")
    public ServerResponse deleteNote(Integer onlineId, HttpServletRequest request) {

        UserVO uservo = (UserVO) request.getSession().getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse = notesService.deleteLogic(onlineId, uservo.getUserId());
        return serverResponse;
    }

    @RequestMapping(value = "searchAllNotes.do")
    public ServerResponse searchAllNotes(HttpServletRequest request) {
        UserVO userVO = (UserVO) request.getSession().getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse = notesService.getNotesList(userVO.getUserName());
        return serverResponse;
    }

}
