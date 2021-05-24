package com.example.wsn.bbsadminsys.controller;
/*
 *project:JavaCode
 *file:Elite
 *@author:wsn
 **date:2021/5/21 9:00
 */

import com.example.wsn.bbsadminsys.dao.ArticleDao;
import com.example.wsn.bbsadminsys.dao.EliteTopDao;
import com.example.wsn.bbsadminsys.domain.AllArtsBean;
import com.example.wsn.bbsadminsys.domain.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/elitetop")

public class Elite {

    @Autowired
    EliteTopDao eliteTopDao;
    @Autowired
    ArticleDao articleDao;

    @RequestMapping("/addelite")
    @Transactional
    public String addElite(int [] idlist){
        String reason="";
        for(int id:idlist){
            int currentnum=eliteTopDao.getEliteNum(id);
            Statistics li = getLimits();
            if(currentnum>=li.getMax_elite()){
                String typeName = articleDao.getTypeName(id);
                reason=reason+typeName+",";
            }
            else eliteTopDao.addElite(id);

        }



        return reason;
    }

    @RequestMapping("/addtop")
    @Transactional
    public String addTop(int [] idlist){
        String reason="";
        for(int id:idlist){
            int currentnum = eliteTopDao.getTopNum(id);
            Statistics li = getLimits();
            if(currentnum>=li.getMax_top()){
                String typeName = articleDao.getTypeName(id);
                reason=reason+typeName+",";
            }
            else eliteTopDao.addTop(id);

        }
        return reason;
    }

    @RequestMapping("/allet")
    @Transactional
    public List<AllArtsBean> getAllEliteTop(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<AllArtsBean> allArts = eliteTopDao.getAllEliteTop();
        if(allArts==null) return null;
        else{
            for(AllArtsBean ab:allArts){
                ab.setFormate_time(sdf.format(ab.getCre_time()));
            }
        }
        return allArts;
    }

    @RequestMapping("getlimits")
    @Transactional
    public Statistics getLimits(){
        return eliteTopDao.getLimits();
    }

    @RequestMapping("/cancelelite")
    @Transactional
    public boolean cancelElite(int art_id){
        eliteTopDao.cancelElite(art_id);
        return true;
    }
    @RequestMapping("/canceltop")
    @Transactional
    public boolean cancelTop(int art_id){
        eliteTopDao.cancelTop(art_id);
        return true;
    }
    @RequestMapping("/editelite")
    @Transactional
    public boolean editElite(int value){
        eliteTopDao.editEliteLimit(value);
        return true;
    }

    @RequestMapping("/edittop")
    @Transactional
    public boolean editTop(int value){
        eliteTopDao.editTopLimit(value);
        return true;
    }
}
