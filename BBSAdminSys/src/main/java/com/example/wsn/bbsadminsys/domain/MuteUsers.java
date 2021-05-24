package com.example.wsn.bbsadminsys.domain;
/*
 *project:JavaCode
 *file:MuteUsers
 *@author:wsn
 *date:2021/5/17 11:20
 */

import java.util.Date;

public class MuteUsers {
    private int u_id;
    private String u_name;
    private Date start_time;
    private String f_s_time;
    private Date end_time;
    private String f_e_time;
    private String reason;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public String getF_s_time() {
        return f_s_time;
    }

    public void setF_s_time(String f_s_time) {
        this.f_s_time = f_s_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getF_e_time() {
        return f_e_time;
    }

    public void setF_e_time(String f_e_time) {
        this.f_e_time = f_e_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
