package com.example.wsn.bbsadminsys.controller;
/*
 *project:JavaCode
 *file:Index
 *@author:wsn
 *date:2021/5/17 11:30
 */


import com.example.wsn.bbsadminsys.dao.ArticleDao;
import com.example.wsn.bbsadminsys.dao.CommonDao;
import com.example.wsn.bbsadminsys.domain.Statistics;
import com.example.wsn.bbsadminsys.domain.TypeNum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/index")
public class Index {

    @Autowired
    CommonDao commonDao;
    @Autowired
    ArticleDao articleDao;

    @RequestMapping("/getdata")
    @Transactional
    public Statistics getData(){
        return commonDao.getStas();
    }
    @RequestMapping("/addvisit")
    public boolean addVisit(){
        commonDao.addVisit();
        return true;
    }

    @RequestMapping("/typenum")
    public List<TypeNum> getNum(){
        return articleDao.getTypeNum();
    }
    @RequestMapping("/typeContnum")
    public List<TypeNum> getContNum(){
        return articleDao.getTypeCommNum();
    }

    @RequestMapping("/getgender")
    public List<TypeNum> getGender(){
        return commonDao.getGenderNums();
    }
    @RequestMapping("/artwnum")
    public List<TypeNum> getWeek(String type){
        if("1".equals(type)) return commonDao.getWeekNums(1);
        else return commonDao.getWeekNums(2);

    }
}
