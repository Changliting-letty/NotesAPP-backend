package com.firstapp.firstappbackend.vo;

import com.firstapp.firstappbackend.pojo.Notes;

public class ResponseVO<T> {
    private int online_id;
    private int offline_id;
    private String operation;
    private NotesVO data;
    private String update_time;
    private String desc;


    public int getOnline_id() {
        return online_id;
    }

    public void setOnline_id(int online_id) {
        this.online_id = online_id;
    }

    public int getOffline_id() {
        return offline_id;
    }

    public void setOffline_id(int offline_id) {
        this.offline_id = offline_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public NotesVO getData() {
        return data;
    }

    public void setData(NotesVO data) {
        this.data = data;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
