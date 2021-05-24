package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:ArticleDao
 *@author:wsn
 *date:2021/5/15 18:25
 */

import com.example.wsn.bbsadminsys.domain.AllArtsBean;
import com.example.wsn.bbsadminsys.domain.TypeNum;

import java.util.List;

public interface ArticleDao {

    List<AllArtsBean> getAllArts();
    List<TypeNum> getTypeNum();
    List<TypeNum> getTypeCommNum();
    void deleteArt(int art_id);
    void deleteCollect(int art_id);
    void deleteArtComm(int art_id);
    void changeType(int art_id,int t_id);
    String getTypeName(int art_id);
}
