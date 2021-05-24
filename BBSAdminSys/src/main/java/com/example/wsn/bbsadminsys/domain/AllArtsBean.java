package com.example.wsn.bbsadminsys.domain;
/*
 *project:JavaCode
 *file:AllArtsBean
 *@author:wsn
 *date:2021/5/1 18:28
 */

import java.util.Date;

public class AllArtsBean {
    private int art_id;
    private String title;
    private String content;
    private String nickname;
    private Date cre_time;
    private String formate_time;
    private String t_name;
    private int likes;
    private int comments;
    private int is_elited;
    private int is_top;


    public int getArt_id() {
        return art_id;
    }

    public void setArt_id(int art_id) {
        this.art_id = art_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCre_time() {
        return cre_time;
    }

    public void setCre_time(Date cre_time) {
        this.cre_time = cre_time;
    }

    public String getFormate_time() {
        return formate_time;
    }

    public void setFormate_time(String formate_time) {
        this.formate_time = formate_time;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getIs_elited() {
        return is_elited;
    }

    public void setIs_elited(int is_elited) {
        this.is_elited = is_elited;
    }

    public int getIs_top() {
        return is_top;
    }

    public void setIs_top(int is_top) {
        this.is_top = is_top;
    }
}
