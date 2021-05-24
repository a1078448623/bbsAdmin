package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:CommentsDaoImpl
 *@author:wsn
 *date:2021/5/20 13:26
 */

import com.example.wsn.bbsadminsys.domain.CommentsBean;
import com.example.wsn.bbsadminsys.domain.DeleListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentsDaoImpl implements CommentsDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<CommentsBean> getAllComments() {

        String sql="select id,title,nickname,comments.content,com_time,reply_floor,floor,to_commt_id,to_art_id " +
                "from user,article,comments " +
                "where re_user_id=user.u_id and art_id=comments.to_art_id " +
                "order by to_art_id,floor ";

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(CommentsBean.class));

    }

    @Override
    public String getToConent(int to_commt_id) {

        String sql="select content from comments where id=?";
        return jdbcTemplate.queryForObject(sql,String.class,to_commt_id);
    }

    @Override
    public List<CommentsBean> serchComments(String keywords) {

        String sql="select id,title,nickname,comments.content,com_time,reply_floor,floor,to_commt_id,to_art_id " +
                "from user,article,comments " +
                "where re_user_id=user.u_id and art_id=comments.to_art_id and locate(?,title)>0 " +
                "order by to_art_id,floor ";

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(CommentsBean.class),keywords);


    }

    @Override
    public void delComment(int id) {
        String sql="delete from comments where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public List<DeleListBean> getDeleList(int to_commmt_id) {

        try {
            String sql = "select id from comments where to_commt_id=?";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(DeleListBean.class), to_commmt_id);
        }catch (DataAccessException e){
            System.out.println("exce!!");
            return null;
        }


    }

    @Override
    public void updateArt(int art_id) {

        String sql="update article set comments=comments-1 where art_id=?";
        jdbcTemplate.update(sql,art_id);
    }
}
