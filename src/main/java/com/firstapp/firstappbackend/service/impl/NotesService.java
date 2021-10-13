package com.firstapp.firstappbackend.service.impl;

import com.firstapp.firstappbackend.common.ResponseCode;
import com.firstapp.firstappbackend.dao.NotesMapper;
import com.firstapp.firstappbackend.dao.UserMapper;
import com.firstapp.firstappbackend.pojo.Notes;
import com.firstapp.firstappbackend.service.INotesService;
import com.firstapp.firstappbackend.utils.MD5Utils;
import com.firstapp.firstappbackend.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesService implements INotesService {
    @Autowired
    NotesMapper notesMapper;
    @Override
    public ServerResponse createLogic(Notes notes,Integer userId) {
        //判空
        if (notes==null){
            return  ServerResponse.createServerResponseByFail(ResponseCode.NOTE_NOT_EMPTY.getCode(),ResponseCode.NOTE_NOT_EMPTY.getMsg());
        }
        notes.setUserId(userId);
        Integer result= notesMapper.insert(notes);
        if (result==0){
            //添加失败
            return  ServerResponse.createServerResponseByFail(ResponseCode.CREATENOTE_FALI.getCode(),ResponseCode.CREATENOTE_FALI.getMsg());
        }
        //添加成功
        return  ServerResponse.createServerResponseBySuccess();
    }

    @Override
    public ServerResponse updateLogic(Notes notes,Integer userId) {
        notes.setUserId(userId);
        int count=notesMapper.updateByUserIdAndTitle(notes);

        if (count == 0) {
            return  ServerResponse.createServerResponseByFail(ResponseCode.UPDATENOTE_FAIL.getCode(),ResponseCode.UPDATENOTE_FAIL.getMsg());
        }
        return  ServerResponse.createServerResponseBySuccess();
    }

    @Override
    public ServerResponse deleteLogic(Notes notes,Integer userId) {
        notes.setUserId(userId);
         Integer count=notesMapper.deleteByTitleAndUserId(notes);
         if (count==0){
             return  ServerResponse.createServerResponseByFail(ResponseCode.DELETENOTE_FAIL.getCode(),ResponseCode.DELETENOTE_FAIL.getMsg());
         }
         return  ServerResponse.createServerResponseBySuccess();
    }
}
