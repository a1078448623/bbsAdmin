package com.example.wsn.bbsadminsys.domain;
/*
 *project:JavaCode
 *file:UserBean
 *@author:wsn
 *date:2021/5/18 11:20
 */

public class UserBean {

    private int u_id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private int is_muted;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIs_muted() {
        return is_muted;
    }

    public void setIs_muted(int is_muted) {
        this.is_muted = is_muted;
    }
}
