package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:NoticeDao
 *@author:wsn
 **date:2021/5/22 19:19
 */

import com.example.wsn.bbsadminsys.domain.AllArtsBean;

import java.util.List;

public interface NoticeDao {
    void addNotice(String title,int type_id,String content);
    List<AllArtsBean> getSysArt();
}
