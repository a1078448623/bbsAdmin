package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:UserDaoImpl
 *@author:wsn
 **date:2021/5/24 15:38
 */

import com.example.wsn.bbsadminsys.domain.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public UserBean getUser(String username) {
        try {
            String sql="select * from user where username=?";
            return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(UserBean.class),username);
        }catch (DataAccessException e){
            return null;
        }
    }
}
