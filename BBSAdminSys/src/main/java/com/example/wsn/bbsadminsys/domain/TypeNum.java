package com.example.wsn.bbsadminsys.domain;
/*
 *project:JavaCode
 *file:TypeNum
 *@author:wsn
 *date:2021/5/17 11:20
 */

public class TypeNum {
    private String t_name;
    private int num;
    private int com_num;
    private String gender;
    private int g_num;
    private int week;
    private int w_num;
    private int w_c_num;

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCom_num() {
        return com_num;
    }

    public void setCom_num(int com_num) {
        this.com_num = com_num;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getW_num() {
        return w_num;
    }

    public void setW_num(int w_num) {
        this.w_num = w_num;
    }

    public int getG_num() {
        return g_num;
    }

    public void setG_num(int g_num) {
        this.g_num = g_num;
    }

    public int getW_c_num() {
        return w_c_num;
    }

    public void setW_c_num(int w_c_num) {
        this.w_c_num = w_c_num;
    }
}
