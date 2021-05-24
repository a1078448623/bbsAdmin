package com.example.wsn.bbsadminsys.controller;
/*
 *project:JavaCode
 *file:Comment
 *@author:wsn
 *date:2021/5/20 10:35
 */

import com.example.wsn.bbsadminsys.dao.CommentsDao;
import com.example.wsn.bbsadminsys.domain.CommentsBean;
import com.example.wsn.bbsadminsys.domain.DeleListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class Comment {

    @Autowired
    CommentsDao commentsDao;

    @RequestMapping("/getallcomts")
    @Transactional
    public List<CommentsBean> getAllCommts(){
        List<CommentsBean> allComments = commentsDao.getAllComments();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(allComments!=null){
            for(CommentsBean cb:allComments){
                cb.setF_time(sdf.format(cb.getCom_time()));
                if(cb.getReply_floor()==0){
                    cb.setHas_floor("--");
                    cb.setIs_reply("否");
                }
                else {
                    cb.setHas_floor(cb.getReply_floor()+"");
                    cb.setIs_reply("是");
                }
                if(cb.getTo_commt_id()==0){
                    cb.setTo_commt_content("--");
                }
                else {
                    cb.setTo_commt_content(commentsDao.getToConent(cb.getTo_commt_id()));
                }

            }
        }
        return allComments;
    }

    @RequestMapping("/serchcommts")
    @Transactional
    public List<CommentsBean> serchCommts(String keywords){
        List<CommentsBean> allComments = commentsDao.serchComments(keywords);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(allComments!=null){
            for(CommentsBean cb:allComments){
                cb.setF_time(sdf.format(cb.getCom_time()));
                if(cb.getReply_floor()==0){
                    cb.setHas_floor("--");
                    cb.setIs_reply("否");
                }
                else {
                    cb.setHas_floor(cb.getReply_floor()+"");
                    cb.setIs_reply("是");
                }
                if(cb.getTo_commt_id()==0){
                    cb.setTo_commt_content("--");
                }
                else {
                    cb.setTo_commt_content(commentsDao.getToConent(cb.getTo_commt_id()));
                }

            }
        }
        return allComments;
    }

    @RequestMapping("/delcomt")
    @Transactional
    public boolean delComment(int id,int to_art_id){

        List<DeleListBean> deleList = commentsDao.getDeleList(id);
        if(deleList.size()!=0){
            for(DeleListBean db:deleList){
                delComment(db.getId(),to_art_id);

            }
        }
        commentsDao.delComment(id);
        commentsDao.updateArt(to_art_id);

        return true;
    }
}
