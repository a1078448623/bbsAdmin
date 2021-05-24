package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:GetAllUsersDaoImpl
 *@author:wsn
 *date:2021/5/17 13:26
 */

import com.example.wsn.bbsadminsys.domain.MuteUsers;
import com.example.wsn.bbsadminsys.domain.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GetAllUsersDaoImpl implements GetAllUsersDao{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<UserBean> getAllusers() {
        String sql="select * from user";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(UserBean.class));

    }

    @Override
    public UserBean getAdmin(String username,String password) {
        try{

            String sql = "select * from user where username=? and password=?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserBean.class), username, password);
        }catch (DataAccessException e){
            return null;
        }
    }

    @Override
    public boolean changeName(int u_id,String newName) {

        try {
            String sql1 = "select nickname from user where nickname=?";
            String s = jdbcTemplate.queryForObject(sql1, String.class, newName);
            return s==null;
        }catch (DataAccessException e){

            String sql="update user set nickname=? where u_id=?";
            jdbcTemplate.update(sql,newName,u_id);
            return true;
        }

    }

    @Override
    public boolean setMute(int u_id, int time, String reason) {

        String sql="select nickname from user where u_id=?";
        String name = jdbcTemplate.queryForObject(sql, String.class, u_id);
        String sql2="insert into mute_list values (null,?,?,default,null,?)";
        jdbcTemplate.update(sql2,u_id,name,reason);
        String sql3="update mute_list set end_time=from_unixtime(unix_timestamp(start_time)+?) where u_id=?";
        jdbcTemplate.update(sql3,time,u_id);
        String sql4="update user set is_muted=1 where u_id=?";
        jdbcTemplate.update(sql4,u_id);
        return true;
    }

    @Override
    public List<MuteUsers> getMuteUser() {

        try {
            String sql = "select * from mute_list";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MuteUsers.class));
        }catch (DataAccessException e){
            return null;
        }

    }

    @Override
    public boolean cancelMute(int u_id) {
        String sql="delete from mute_list where u_id=?";
        int i = jdbcTemplate.update(sql, u_id);

        String sql2="update user set is_muted=0 where u_id=?";
        int i1 = jdbcTemplate.update(sql2, u_id);
        return i1>0;
    }

    @Override
    public boolean addMute(int u_id, int time) {
        String sql="update mute_list set end_time=from_unixtime(unix_timestamp(end_time)+?) where u_id=?";
        int i = jdbcTemplate.update(sql, time, u_id);
        return i>0;
    }

    @Override
    public boolean changeNamePass(int u_id, String username, String password) {

        try{
            String sql = "select username from user where username=? and u_id<>?";
            jdbcTemplate.queryForObject(sql, String.class, username,u_id);
            return false;
        }catch (DataAccessException e){
            String sql2="update user set username=?,password=? where u_id=?";
            int i = jdbcTemplate.update(sql2, username, password, u_id);
            return i>0;
        }

    }

    @Override
    public boolean deleUsers(int[] idlist) {
        String sql="delete from user where u_id=?";
        for(int u_id:idlist){
            jdbcTemplate.update(sql,u_id);
        }
        return true;
    }

    @Override
    public boolean addUser(String username, String password, String nickname, String gender) {

        String sql="insert into user values (null,?,?,?,default,?,default);";
        int i = jdbcTemplate.update(sql, username, password, nickname, gender);
        return i>0;
    }
}
