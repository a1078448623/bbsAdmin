package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:NoticeDaoImpl
 *@author:wsn
 **date:2021/5/22 19:19
 */

import com.example.wsn.bbsadminsys.domain.AllArtsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoticeDaoImpl implements NoticeDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addNotice(String title, int type_id, String content) {

        String sql="insert into article values(null,?,?,?,?,default,default,default,?,?) ";
        jdbcTemplate.update(sql,"1",type_id,title,content,"1","1");
    }

    @Override
    public List<AllArtsBean> getSysArt() {

        try {
            String sql = "select art_id,title,content,nickname,cre_time,t_name,likes,comments,is_elited,is_top " +
                    "from " +
                    " article,user,art_type " +
                    "where " +
                    " auth_id=user.u_id and t_id=article.type_id and auth_id=?";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AllArtsBean.class), "1");
        }catch (DataAccessException e){
            return null;
        }

    }


}
