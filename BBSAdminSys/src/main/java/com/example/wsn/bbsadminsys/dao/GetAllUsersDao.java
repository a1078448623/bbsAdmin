package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:GetAllUsersDao
 *@author:wsn
 *date:2021/5/17 13:25
 */

import com.example.wsn.bbsadminsys.domain.MuteUsers;
import com.example.wsn.bbsadminsys.domain.UserBean;

import java.util.List;

public interface GetAllUsersDao {

    List<UserBean> getAllusers();
    UserBean getAdmin(String username,String password);
    boolean changeName(int u_id,String newName);
    boolean setMute(int u_id,int time,String reason);
    List<MuteUsers> getMuteUser();
    boolean cancelMute(int u_id);
    boolean addMute(int u_id,int time);
    boolean changeNamePass(int u_id,String username,String password);
    boolean deleUsers(int [] idlist);
    boolean addUser(String username,String password,String nickname,String gender);
}
