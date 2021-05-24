package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:TypesDaoImpl
 *@author:wsn
 *date:2021/5/18 11:20
 */

import com.example.wsn.bbsadminsys.domain.ArtTypeDao;
import com.example.wsn.bbsadminsys.domain.TypeNames;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TypesDaoImpl implements TypesDao{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<TypeNames> getAllType() {

        String sql="select * from art_type";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(TypeNames.class));

    }

    @Override
    public boolean changeFname(String oldname, String newname) {

        String sql="update art_type set father_name=? where father_name=?";
        int i = jdbcTemplate.update(sql, newname, oldname);
        return i>0;
    }

    @Override
    public void changeCname(int t_id, String newname) {
        String sql="update art_type set t_name=? where t_id=?";
        jdbcTemplate.update(sql,newname,t_id);

    }

    @Override
    public String getFname(int t_id) {
        String sql="select father_name from art_type where t_id=?";
        return jdbcTemplate.queryForObject(sql,String.class,t_id);

    }

    @Override
    public void delArtDueToType(int t_id) {

        String sql="delete from article where type_id=?";
        jdbcTemplate.update(sql,t_id);
    }

    @Override
    public List<ArtTypeDao> getTypeArt(int t_id) {

        String sql="select art_id,type_id from article where type_id=?";
        jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(ArtTypeDao.class),t_id);
        return null;
    }

    @Override
    public void delChildType(int t_id) {

        String sql="delete from art_type where t_id=?";
        jdbcTemplate.update(sql,t_id);
    }

    @Override
    public List<TypeNames> getFaCh(String fname) {
        String sql="select * from art_type where father_name=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(TypeNames.class),fname);
    }

    @Override
    public void addNewType(String childname, String fathername) {

        String sql="insert into art_type values (null,?,?,default)";
        jdbcTemplate.update(sql,childname,fathername);
    }

    @Override
    public void updateImgName(int t_id,String filename) {

        String sql="update art_type set back_img=? where t_id=?";
        jdbcTemplate.update(sql,filename,t_id);
    }
}
