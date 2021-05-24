
package com.example.wsn.bbsadminsys.controller;
/*
 *project:JavaCode
 *file:Article
 *@author:wsn
 *date:2021/5/15 18:23
 */

import com.example.wsn.bbsadminsys.dao.ArticleDao;
import com.example.wsn.bbsadminsys.domain.AllArtsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/article")
public class Article {

    @Autowired
    ArticleDao articleDao;
    @RequestMapping("/allarts")
    @Transactional
    public List<AllArtsBean> allArts(){

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<AllArtsBean> allArts = articleDao.getAllArts();
        if(allArts==null) return null;
        else{
            for(AllArtsBean ab:allArts){
                ab.setFormate_time(sdf.format(ab.getCre_time()));
            }
        }
        return allArts;
    }

    @RequestMapping("/delart")
    @Transactional
    public boolean delArt(int art_id){
        articleDao.deleteCollect(art_id);
        articleDao.deleteArtComm(art_id);
        articleDao.deleteArt(art_id);
        return true;
    }

    @RequestMapping("/changetype")
    public boolean changeType(int t_id,int art_id){
        articleDao.changeType(art_id,t_id);
        return true;
    }
}
