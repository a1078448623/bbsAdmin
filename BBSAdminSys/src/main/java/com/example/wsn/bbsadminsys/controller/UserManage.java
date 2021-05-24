package com.example.wsn.bbsadminsys.controller;
/*
 *project:JavaCode
 *file:UserManage
 *@author:wsn
 *date:2021/5/17 10:46
 */

import com.example.wsn.bbsadminsys.dao.GetAllUsersDao;
import com.example.wsn.bbsadminsys.domain.MuteUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserManage {

    @Autowired
    GetAllUsersDao getAllUsersDao;

    @RequestMapping("/changeName")
    public boolean changeName(int u_id,String newName){

        return getAllUsersDao.changeName(u_id,newName);
    }
    @RequestMapping("/setmute")
    public boolean setMute(int u_id,int time,String reason){

        time=time*24*60*60;
        return getAllUsersDao.setMute(u_id,time,reason);
    }

    @RequestMapping("/getmutes")
    public List<MuteUsers> getMuteUser(){
        List<MuteUsers> muteUser = getAllUsersDao.getMuteUser();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(muteUser!=null){
            for (MuteUsers mu:muteUser){
                mu.setF_s_time(sdf.format(mu.getStart_time()));
                mu.setF_e_time(sdf.format(mu.getEnd_time()));
            }
            return muteUser;
        }
        else return null;
    }

    @RequestMapping("/cancelmute")
    public boolean cancelMute(int u_id){

        return getAllUsersDao.cancelMute(u_id);
    }

    @RequestMapping("/addtime")
    public boolean addTime(int u_id,int time){
        time=time*24*60*60;
        return getAllUsersDao.addMute(u_id,time);
    }
    @RequestMapping("/changeup")
    public boolean changeNamePass(int u_id,String username,String password){

        return getAllUsersDao.changeNamePass(u_id,username,password);
    }
    @RequestMapping("/deleuser")
    public boolean deleUser(int[] idlist){

        if(idlist.length>0) return getAllUsersDao.deleUsers(idlist);
        else return false;
    }
    @RequestMapping("/adduser")
    public boolean addUser(String username,String password,String nickname,String gender){
        return getAllUsersDao.addUser(username,password,nickname,gender);
    }
}
