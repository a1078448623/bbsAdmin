package com.example.wsn.bbsadminsys.controller;
/*
 *project:JavaCode
 *file:Notice
 *@author:wsn
 **date:2021/5/22 19:10
 */

import com.example.wsn.bbsadminsys.dao.ArticleDao;
import com.example.wsn.bbsadminsys.dao.NoticeDao;
import com.example.wsn.bbsadminsys.domain.AllArtsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/notice")
public class Notice {

    @Autowired
    NoticeDao noticeDao;

    @Autowired
    ArticleDao articleDao;

    @RequestMapping("/addnotice")
    public boolean addNotice(String title,int type_id,String content){
        noticeDao.addNotice(title,type_id,content);
        return true;
    }

    @RequestMapping("/getnotice")
    @Transactional
    public List<AllArtsBean> getSysArt(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<AllArtsBean> sysArt = noticeDao.getSysArt();

        if(sysArt.size()>0){
            for(AllArtsBean ab:sysArt){
                ab.setFormate_time(sdf.format(ab.getCre_time()));
            }
        }
        return sysArt;
    }

    @RequestMapping("/delnotice")
    @Transactional
    public boolean delNotice(int art_id){
        articleDao.deleteCollect(art_id);
        articleDao.deleteArtComm(art_id);
        articleDao.deleteArt(art_id);
        return true;

    }
}
