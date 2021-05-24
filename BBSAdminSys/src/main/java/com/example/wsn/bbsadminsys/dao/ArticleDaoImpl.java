package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:ArticleDaoImpl
 *@author:wsn
 *date:2021/5/15 18:26
 */

import com.example.wsn.bbsadminsys.domain.AllArtsBean;
import com.example.wsn.bbsadminsys.domain.TypeNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<AllArtsBean> getAllArts() {
        try{
            String sql = "select art_id,title,content,nickname,cre_time,t_name,likes,comments,is_elited,is_top " +
                    "from " +
                    " article,user,art_type " +
                    "where " +
                    " auth_id=user.u_id and t_id=article.type_id";
           return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AllArtsBean.class));
        }catch (DataAccessException e){
            return null;
        }

    }

    @Override
    public List<TypeNum> getTypeNum() {

        String sql="select t_name,count(*) as num " +
                "from art_type,article " +
                "where t_id=article.type_id " +
                "group by t_id ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(TypeNum.class));

    }

    @Override
    public List<TypeNum> getTypeCommNum() {
        String sql="select t_name,count(*) as com_num " +
                "from art_type,article,comments " +
                "where t_id=article.type_id and to_art_id=article.art_id " +
                "group by t_id ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(TypeNum.class));

    }

    @Override
    public void deleteArt(int art_id) {



        String sql3="delete from article where art_id=?";

        jdbcTemplate.update(sql3,art_id);
    }

    @Override
    public void deleteCollect(int art_id) {
        String sql2="delete from collect where art_id=?";
        jdbcTemplate.update(sql2,art_id);
    }

    @Override
    public void deleteArtComm(int art_id) {
        String sql1="delete from comments where to_art_id=?";
        jdbcTemplate.update(sql1,art_id);

    }

    @Override
    public void changeType(int art_id, int t_id) {

        String sql="update article set type_id=? where art_id=?";
        jdbcTemplate.update(sql,t_id,art_id);
    }

    @Override
    public String getTypeName(int art_id) {
        String sql="select t_name from art_type,article where art_id=? and type_id=art_type.t_id";
        return jdbcTemplate.queryForObject(sql,String.class,art_id);
    }
}
