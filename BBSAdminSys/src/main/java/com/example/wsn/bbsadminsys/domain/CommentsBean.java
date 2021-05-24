package com.example.wsn.bbsadminsys.domain;
/*
 *project:JavaCode
 *file:CommentsBean
 *@author:wsn
 *date:2021/5/20 11:20
 */

import java.util.Date;

public class CommentsBean {
    private int id;
    private String title;
    private String nickname;
    private String content;
    private Date com_time;
    private String f_time;
    private int floor;
    private int reply_floor;
    private int to_commt_id;
    private String to_commt_content;
    private String is_reply;
    private String has_floor;
    private int to_art_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCom_time() {
        return com_time;
    }

    public void setCom_time(Date com_time) {
        this.com_time = com_time;
    }

    public String getF_time() {
        return f_time;
    }

    public void setF_time(String f_time) {
        this.f_time = f_time;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getReply_floor() {
        return reply_floor;
    }

    public void setReply_floor(int reply_floor) {
        this.reply_floor = reply_floor;
    }

    public int getTo_commt_id() {
        return to_commt_id;
    }

    public void setTo_commt_id(int to_commt_id) {
        this.to_commt_id = to_commt_id;
    }

    public String getTo_commt_content() {
        return to_commt_content;
    }

    public void setTo_commt_content(String to_commt_content) {
        this.to_commt_content = to_commt_content;
    }

    public String getIs_reply() {
        return is_reply;
    }

    public void setIs_reply(String is_reply) {
        this.is_reply = is_reply;
    }

    public String getHas_floor() {
        return has_floor;
    }

    public void setHas_floor(String has_floor) {
        this.has_floor = has_floor;
    }

    public int getTo_art_id() {
        return to_art_id;
    }

    public void setTo_art_id(int to_art_id) {
        this.to_art_id = to_art_id;
    }
}
