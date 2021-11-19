package com.firstapp.firstappbackend.service.impl;

import com.firstapp.firstappbackend.common.ResponseCode;
import com.firstapp.firstappbackend.dao.ChangeMapper;
import com.firstapp.firstappbackend.dao.NotesMapper;
import com.firstapp.firstappbackend.dao.UserMapper;
import com.firstapp.firstappbackend.pojo.Change;
import com.firstapp.firstappbackend.pojo.Notes;
import com.firstapp.firstappbackend.pojo.User;
import com.firstapp.firstappbackend.service.INotesService;
import com.firstapp.firstappbackend.utils.DateUtil;
import com.firstapp.firstappbackend.utils.MD5Utils;
import com.firstapp.firstappbackend.utils.ServerResponse;
import com.firstapp.firstappbackend.vo.NotesVO;
import com.firstapp.firstappbackend.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NotesService implements INotesService {
    @Autowired
    NotesMapper notesMapper;
    @Autowired
    ChangeMapper changeMapper;

    @Override
    public ServerResponse createLogic(NotesVO notesvo, Integer userId) {
        //判空
        if (notesvo == null) {
            return ServerResponse.createServerResponseByFail(ResponseCode.NOTE_NOT_EMPTY.getCode(), ResponseCode.NOTE_NOT_EMPTY.getMsg());
        }
        Notes notes = Reconvert(notesvo);
        Integer result = notesMapper.insert(notes);
//        Change change=new Change();
//        change.setUserId(userId);
//        System.out.print("notes.id%d"+notes.getId());
//        change.setNoteId(notes.getId());
//        change.setOperation("add");
//        int change_res=changeMapper.insert(change);
        if (result == 0) {
            //添加失败
            return ServerResponse.createServerResponseByFail(ResponseCode.CREATENOTE_FALI.getCode(), ResponseCode.CREATENOTE_FALI.getMsg());
        }
        //未处理change_res为0的情况


        //添加成功
        //return  ServerResponse.createServerResponseBySuccess(ResponseCode.IS_CREATENOTE_SUCCESS.getCode(),convert(notes),ResponseCode.IS_CREATENOTE_SUCCESS.getMsg());
        HashMap<String, Integer> resMap = new HashMap<>();
        resMap.put("offline_id", notesvo.getId());
        resMap.put("online_id", notes.getId());
        return ServerResponse.createServerResponseBySuccess(ResponseCode.IS_CREATENOTE_SUCCESS.getCode(), resMap, ResponseCode.IS_CREATENOTE_SUCCESS.getMsg());
    }

    @Override
    public ServerResponse updateLogic(Integer onlineId, NotesVO notesVO, Integer userId) {
        Notes notes = Reconvert(notesVO);
        notes.setId(onlineId);
        int count = notesMapper.updateByPrimaryKey(notes);
//        Change change=new Change();
//        change.setUserId(userId);
//        change.setNoteId(notes.getId());
//        change.setOperation("update");
//        int change_res=changeMapper.insert(change);
        //未添加同步出错的情况


        if (count == 0) {
            return ServerResponse.createServerResponseByFail(ResponseCode.UPDATENOTE_FAIL.getCode(), ResponseCode.UPDATENOTE_FAIL.getMsg());
        }
        return ServerResponse.createServerResponseBySuccess(notes.getId());
    }

    @Override
    public ServerResponse deleteLogic(Integer onlineId, Integer userId) {
        Integer count = notesMapper.deleteByPrimaryKey(onlineId);
//        Change change=new Change();
//        change.setUserId(userId);
//        change.setNoteId(onlineId);
//        change.setOperation("delete");
//        int change_res=changeMapper.insert(change);
        if (count == 0) {
            return ServerResponse.createServerResponseByFail(ResponseCode.DELETENOTE_FAIL.getCode(), ResponseCode.DELETENOTE_FAIL.getMsg());
        }
        return ServerResponse.createServerResponseBySuccess(onlineId);
    }

    private NotesVO convert(Notes notes) {
        NotesVO notesVO = new NotesVO();
        notesVO.setId(notes.getId());
        notesVO.setUserId(notes.getUserId());
        notesVO.setTitle(notes.getTitle());
        notesVO.setSubTitle(notes.getSubTitle());
        notesVO.setNoteText(notes.getNoteText());
        notesVO.setCreateTime(DateUtil.dataToString(notes.getCreateTime()));
        notesVO.setDateTime(DateUtil.dataToString(notes.getDateTime()));
        notesVO.setImgPath(notes.getImgPath());
        notesVO.setWebLink(notes.getWebLink());
        notesVO.setColor(notes.getColor());
        return notesVO;
    }

    private Notes Reconvert(NotesVO notesVO) {
        Notes notes = new Notes();
        notes.setUserId(notesVO.getUserId());
        notes.setTitle(notesVO.getTitle());
        notes.setTitle(notesVO.getTitle());
        notes.setSubTitle(notesVO.getSubTitle());
        notes.setNoteText(notesVO.getNoteText());
//        notes.setCreateTime(DateUtil.stringToDate(notesVO.getCreateTime()));
//        notes.setDateTime(DateUtil.stringToDate(notesVO.getDateTime()));
        notes.setImgPath(notesVO.getImgPath());
        notes.setWebLink(notesVO.getWebLink());
        notes.setColor(notesVO.getColor());
        return notes;
    }

    //获取用户的所有Notes
    @Override
    public ServerResponse getNotesList(String userName) {
        List<NotesVO> reslist = new ArrayList<>();
        List<Notes> list = notesMapper.selectAll(userName);
        if (list == null || list.size() == 0) {
            return ServerResponse.createServerResponseByFail(ResponseCode.NOTE_NOT_EXISTS.getCode(), ResponseCode.NOTE_NOT_EXISTS.getMsg());
        }
        //转换
        for (Notes note : list) {
            reslist.add(convert(note));
        }
        return ServerResponse.createServerResponseBySuccess(reslist);
    }
}
