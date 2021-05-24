package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:EliteTopDaoImpl
 *@author:wsn
 **date:2021/5/21 10:23
 */

import com.example.wsn.bbsadminsys.domain.AllArtsBean;
import com.example.wsn.bbsadminsys.domain.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EliteTopDaoImpl implements EliteTopDao{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void addElite(int id) {

        String sql="update article set is_elited=1 where art_id=?";
        jdbcTemplate.update(sql,id);

    }

    @Override
    public void addTop(int id) {
        String sql="update article set is_top=1 where art_id=?";

        jdbcTemplate.update(sql,id);

    }

    @Override
    public List<AllArtsBean> getAllEliteTop() {
        try{
            String sql = "select art_id,title,content,nickname,cre_time,t_name,likes,comments,is_elited,is_top " +
                    "from " +
                    " article,user,art_type " +
                    "where " +
                    " auth_id=user.u_id and t_id=article.type_id and (is_elited=1 or is_top=1) " +
                    "order by t_name";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AllArtsBean.class));
        }catch (DataAccessException e){
            return null;
        }
    }

    @Override
    public Statistics getLimits() {

        Statistics s=new Statistics();
        String sql1="select value from sysdata where type=?";
        String sql2="select value from sysdata where type=?";
        Integer max_elite = jdbcTemplate.queryForObject(sql1, Integer.class, "max_elite");
        Integer max_top = jdbcTemplate.queryForObject(sql2, Integer.class, "max_top");
        s.setMax_elite(max_elite);s.setMax_top(max_top);
        return s;

    }

    @Override
    public void cancelElite(int art_id) {

        String sql="update article set is_elited=0 where art_id=?";
        jdbcTemplate.update(sql,art_id);
    }

    @Override
    public void cancelTop(int art_id) {

        String sql="update article set is_top = 0 where art_id=?";
        jdbcTemplate.update(sql,art_id);
    }

    @Override
    public void editEliteLimit(int value) {

        String sql="update sysdata set value=? where type=?";
        jdbcTemplate.update(sql,value,"max_elite");
    }

    @Override
    public void editTopLimit(int value) {

        String sql="update sysdata set value=? where type=?";
        jdbcTemplate.update(sql,value,"max_top");
    }

    @Override
    public int getEliteNum(int art_id) {

        try{
            String sql = "select count(*) from article " +
                    "where is_elited=1 and type_id=(select type_id from article where art_id=?) " +
                    "group by type_id";
            return jdbcTemplate.queryForObject(sql, Integer.class, art_id);
        }catch (DataAccessException e){
            return 0;
        }
    }

    @Override
    public int getTopNum(int art_id) {
        try {
            String sql = "select count(*) from article " +
                    "where is_top=1 and type_id=(select type_id from article where art_id=?) " +
                    "group by type_id";
            return jdbcTemplate.queryForObject(sql, Integer.class, art_id);
        } catch (DataAccessException e){
            return 0;
        }
    }
}
