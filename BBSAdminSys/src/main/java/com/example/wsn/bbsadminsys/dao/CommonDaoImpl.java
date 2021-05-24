package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:CommonDaoImpl
 *@author:wsn
 *date:2021/5/16 13:26
 */

import com.example.wsn.bbsadminsys.domain.Statistics;
import com.example.wsn.bbsadminsys.domain.TypeNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommonDaoImpl implements CommonDao{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Statistics getStas() {
        Statistics s=new Statistics();

        String sql1="select count(*) from user";
        String sql2="select count(*) from article";

        String sql3="select count(*) from comments";
        String sql4="select value from sysdata where type=?";
        Integer u_count = jdbcTemplate.queryForObject(sql1, Integer.class);
        Integer art_count = jdbcTemplate.queryForObject(sql2, Integer.class);
        Integer commt_count = jdbcTemplate.queryForObject(sql3, Integer.class);
        Integer visit_count = jdbcTemplate.queryForObject(sql4, Integer.class, "visit_count");
        s.setU_dount(u_count);s.setArt_count(art_count);s.setCommt_count(commt_count);s.setVisit_count(visit_count);
        return s;

    }

    @Override
    public List<TypeNum> getGenderNums() {

        String sql="select gender,count(*) as g_num " +
                "from user " +
                "group by gender";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(TypeNum.class));

    }

    @Override
    public List<TypeNum> getWeekNums(int type) {
        String sql="select count(*) as w_num,DAYOFWEEK(cre_time) as week " +
                "from article " +
                "group by DAYOFWEEK(cre_time) " +
                "order by DAYOFWEEK(cre_time)";
        String sql2="select count(*) as w_c_num,DAYOFWEEK(com_time) as week " +
                "from comments " +
                "group by DAYOFWEEK(com_time) " +
                "order by DAYOFWEEK(com_time)";
        if(type==1)
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TypeNum.class));
        else  return jdbcTemplate.query(sql2, new BeanPropertyRowMapper<>(TypeNum.class));

    }

    @Override
    public void addVisit() {

        String sql="update sysdata set value=value+1 where type=?";
        jdbcTemplate.update(sql,"visit_count");
    }
}
