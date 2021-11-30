package com.firstapp.firstappbackend.service.impl;

import com.firstapp.firstappbackend.common.ResponseCode;
import com.firstapp.firstappbackend.dao.ChangeLogMapper;
import com.firstapp.firstappbackend.dao.NotesMapper;
import com.firstapp.firstappbackend.pojo.ChangeLog;
import com.firstapp.firstappbackend.pojo.Notes;
import com.firstapp.firstappbackend.service.INotesService;
import com.firstapp.firstappbackend.utils.DateUtil;
import com.firstapp.firstappbackend.utils.ServerResponse;
import com.firstapp.firstappbackend.vo.NotesVO;
import com.firstapp.firstappbackend.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NotesService implements INotesService {
    @Autowired
    NotesMapper notesMapper;
    @Autowired
    ChangeLogMapper changeLogMapper;

    @Override
    public ServerResponse createLogic(NotesVO notesvo, Integer userId) {
        //判空
        if (notesvo == null) {
            return ServerResponse.createServerResponseByFail(ResponseCode.NOTE_NOT_EMPTY.getCode(), ResponseCode.NOTE_NOT_EMPTY.getMsg(), userId);
        }
        Notes notes = Reconvert(notesvo);
        Integer result = notesMapper.insert(notes);
        //未处理change_res为0的情况
        ChangeLog change = new ChangeLog();
        change.setUserId(userId);
        System.out.print("notes.id%d" + notes.getId());
        change.setNoteId(notes.getId());
        change.setOperation("add");
        int change_res = changeLogMapper.insert(change);
        //添加成功
        //return  ServerResponse.createServerResponseBySuccess(ResponseCode.IS_CREATENOTE_SUCCESS.getCode(),convert(notes),ResponseCode.IS_CREATENOTE_SUCCESS.getMsg());
        if (result == 0 && change_res == 0) {
            //添加失败
            return ServerResponse.createServerResponseByFail(ResponseCode.CREATENOTE_FALI.getCode(), ResponseCode.CREATENOTE_FALI.getMsg(), userId);
        }
        HashMap<String, Integer> resMap = new HashMap<>();
        resMap.put("offline_id", notesvo.getId());
        resMap.put("online_id", notes.getId());
        return ServerResponse.createServerResponseBySuccess(ResponseCode.IS_CREATENOTE_SUCCESS.getCode(), resMap, ResponseCode.IS_CREATENOTE_SUCCESS.getMsg(), userId);
    }

    @Override
    public ServerResponse updateLogic(Integer onlineId, NotesVO notesVO, Integer userId) {
        Notes notes = Reconvert(notesVO);
        notes.setId(onlineId);
        int count = notesMapper.updateByPrimaryKey(notes);
        ChangeLog change = new ChangeLog();
        change.setUserId(userId);
        change.setNoteId(notes.getId());
        change.setOperation("update");
        int change_res = changeLogMapper.insert(change);
        //未添加同步出错的情况
        if (count == 0 && change_res == 0) {
            return ServerResponse.createServerResponseByFail(ResponseCode.UPDATENOTE_FAIL.getCode(), ResponseCode.UPDATENOTE_FAIL.getMsg(), userId);
        }
        return ServerResponse.createServerResponseBySuccess(ResponseCode.IS_UPDATENOTE_SUCCESS.getCode(), notes.getId(), ResponseCode.IS_UPDATENOTE_SUCCESS.getMsg(), userId);
    }

    @Override
    public ServerResponse deleteLogic(Integer onlineId, Integer userId) {
        Integer count = notesMapper.deleteByPrimaryKey(onlineId);
        ChangeLog change = new ChangeLog();
        change.setUserId(userId);
        change.setNoteId(onlineId);
        change.setOperation("delete");
        int change_res = changeLogMapper.insert(change);
        if (count == 0 && change_res == 0) {
            return ServerResponse.createServerResponseByFail(ResponseCode.DELETENOTE_FAIL.getCode(), ResponseCode.DELETENOTE_FAIL.getMsg(), userId);
        }
        return ServerResponse.createServerResponseBySuccess(onlineId, userId);
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
    public ServerResponse getNotesList(Integer userId) {
        List<NotesVO> reslist = new ArrayList<>();
        List<Notes> list = notesMapper.selectAll(userId);
        if (list == null || list.size() == 0) {
            return ServerResponse.createServerResponseByFail(ResponseCode.NOTE_NOT_EXISTS.getCode(), ResponseCode.NOTE_NOT_EXISTS.getMsg(), userId);
        }
        //转换
        for (Notes note : list) {
            reslist.add(convert(note));
        }
        return ServerResponse.createServerResponseBySuccess(reslist, userId);
    }

    /**
     * 任务：
     * 处理冲突，得到两个结果
     * 1：server端需更新的-》更新
     * 2：返回notes端需要更新的data
     */
    @Override
    public ServerResponse handleSyn(Integer userId, String lastSynTime, List<ResponseVO> list) {
        //从change表获取lastSyntime 后的所有更新
        List<ChangeLog> changeLogs = changeLogMapper.selectByTime(DateUtil.stringToDate(lastSynTime));
        System.out.println("handleSyn,满足要求的changeLog的个数: " + changeLogs.size());
        ArrayList<ResponseVO> reslist = new ArrayList<>();//合并冲突后返回给前端的内容
        ArrayList<ResponseVO> updateToserver = new ArrayList<>(); //在server端更新的内容
        HashMap<Integer, ResponseVO> update_map = new HashMap<>();
        HashMap<Integer, ResponseVO> delete_map = new HashMap<>();
        System.out.println(list.size());
        for (ResponseVO responseVO : list) {
            if (responseVO.getOperation().equals("add")) {
                System.out.println(responseVO.getOperation());
                updateToserver.add(responseVO);
            } else if (responseVO.getOperation().equals("update")) {
                System.out.println(responseVO.getOperation());
                if (changeLogs.size() == 0) {
                    updateToserver.add(responseVO);
                } else {
                    update_map.put(responseVO.getOnline_id(), responseVO);
                }
            } else {
                //delete
                System.out.println(responseVO.getOperation());
                if (changeLogs.size() == 0) {
                    updateToserver.add(responseVO);
                } else {
                    delete_map.put(responseVO.getOnline_id(), responseVO);
                }

            }
        }
        if (changeLogs.size() != 0) {
            for (ChangeLog change : changeLogs) {
                int notes_id = change.getNoteId();
                if (change.getOperation().equals("add")) {
                    Notes notes = notesMapper.selectByPrimaryKey(notes_id);
                    ResponseVO responseVO = new ResponseVO();
                    responseVO.setOnline_id(notes_id);
                    responseVO.setOperation("add");
                    responseVO.setData(convert(notes));
                    responseVO.setUpdate_time(DateUtil.dataToString(change.getUpdateTime()));
                    responseVO.setDesc("request");
                    reslist.add(responseVO);
                } else if (change.getOperation().equals("update")) {
                    if (update_map.containsKey(notes_id)) {
                        //保留最新的
                        ResponseVO responseVO = update_map.get(notes_id);
                        NotesVO noteVo=responseVO.getData();
                        String client_update=noteVo.getDateTime();
                        if (change.getUpdateTime().before(DateUtil.stringToDate(client_update))){
                            //本地新，更新到服务端
                            updateToserver.add(responseVO);

                        } else {
                            //服务端新，更新到本地
                            Notes notes = notesMapper.selectByPrimaryKey(notes_id);
                            ResponseVO temp_responseVO = new ResponseVO();
                            responseVO.setOnline_id(change.getNoteId());
                            responseVO.setOperation("update");
                            responseVO.setData(convert(notes));
                            responseVO.setUpdate_time(DateUtil.dataToString(change.getUpdateTime()));
                            responseVO.setDesc("request");
                            reslist.add(temp_responseVO);
                        }
                        update_map.remove(notes_id);
                    } else {
                        //更新到本地
                        Notes notes = notesMapper.selectByPrimaryKey(notes_id);
                        ResponseVO responseVO = new ResponseVO();
                        responseVO.setOnline_id(change.getNoteId());
                        responseVO.setOperation("update");
                        responseVO.setData(convert(notes));
                        responseVO.setDesc("request");
                        responseVO.setUpdate_time(DateUtil.dataToString(change.getUpdateTime()));
                        reslist.add(responseVO);
                    }
                } else {
                    //delete的情况
                    //1.交互的clent端没有delet
                    if (delete_map.containsKey(notes_id)) {
                        delete_map.remove(notes_id);
                    } else {
                        ResponseVO responseVO = new ResponseVO();
                        responseVO.setOnline_id(notes_id);
                        responseVO.setOperation("delete");
                        responseVO.setDesc("request");
                        responseVO.setUpdate_time(DateUtil.dataToString(change.getUpdateTime()));
                        reslist.add(responseVO);
                    }
                    //2.有的情况就不要用考虑了，clent端和server端都删除了
                }
            }
        }
        //处理冲突后，server端需要更新的部分
        //剩下的delete_id_list都需要在后端删除
        for (ResponseVO responseVO : delete_map.values()) {
            updateToserver.add(responseVO);
        }
        //剩下的update_map都是需要更新到本地的
        for (ResponseVO responseVO : update_map.values()) {
            updateToserver.add(responseVO);
        }
        reslist.addAll(updateInServer(updateToserver, userId));
        //返回前端
        return ServerResponse.createServerResponseBySuccess(reslist, userId);
    }

    public ArrayList<ResponseVO> updateInServer(ArrayList<ResponseVO> list, Integer user_id) {
        ArrayList<ResponseVO> res = new ArrayList<>();
        for (ResponseVO responseVO : list) {
            if (responseVO.getOperation().equals("add")) {
                System.out.println("服务端执行Add");
                NotesVO notesVO = responseVO.getData();
                if (responseVO.getData() == null) {
                    System.out.println("客户端添加了空白notes，忽略");
                } else {
                    Notes notes = Reconvert(notesVO);
                    Integer result = notesMapper.insert(notes);
                    ChangeLog change = new ChangeLog();
                    change.setUserId(user_id);
                    change.setNoteId(notes.getId());
                    change.setOperation("add");
                    int change_res = changeLogMapper.insert(change);
                    if (result == 0 || change_res == 0) {
                        //这里处理服务端插入失败的问题,待处理。。。
                        System.out.println("notes和change_log出现了不一致");
                    } else {
                        ResponseVO responseVO1 = new ResponseVO();
                        responseVO1.setDesc("response");
                        responseVO1.setOperation("add");
                        responseVO1.setOffline_id(responseVO.getOffline_id());
                        responseVO1.setOnline_id(notes.getId());
                        res.add(responseVO1);
                    }
                }

            } else if (responseVO.getOperation().equals("update")) {
                System.out.println("服务端执行update");
                NotesVO notesVO = responseVO.getData();
                Notes notes = Reconvert(notesVO);
                notes.setId(responseVO.getOnline_id());
                int count = notesMapper.updateByPrimaryKey(notes);
                ChangeLog change = new ChangeLog();
                change.setUserId(notesVO.getUserId());
                change.setNoteId(notes.getId());
                change.setOperation("update");
                int change_res = changeLogMapper.insert(change);
                //未添加同步出错的情况
                if (count == 0 || change_res == 0) {
                    System.out.println("notes和change_log出现了不一致");
                    //处理未更新成功的情况
                } else {
                    ResponseVO responseVO1 = new ResponseVO();
                    responseVO1.setDesc("response");
                    responseVO1.setOperation("update");
                    responseVO1.setOffline_id(responseVO.getOffline_id());
                    responseVO1.setOnline_id(notes.getId());
                    res.add(responseVO1);
                }
            } else {
                System.out.println("服务端执行delete");
                Integer count = notesMapper.deleteByPrimaryKey(responseVO.getOnline_id());
                ChangeLog change = new ChangeLog();
                change.setUserId(user_id);
                change.setNoteId(responseVO.getOnline_id());
                change.setOperation("delete");
                int change_res = changeLogMapper.insert(change);
                if (count == 0 && change_res == 0) {
                    System.out.println("notes和change_log出现了不一致");
                    //处理未更新成功的情况
                } else {
                    ResponseVO responseVO1 = new ResponseVO();
                    responseVO1.setDesc("response");
                    responseVO1.setOperation("delete");
                    responseVO1.setOffline_id(responseVO.getOffline_id());
                    responseVO1.setOnline_id(responseVO.getOnline_id());
                    res.add(responseVO1);
                }
            }
        }
        return res;
    }
}
