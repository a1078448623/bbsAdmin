package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:CommentsDao
 *@author:wsn
 *date:2021/5/20 13:25
 */

import com.example.wsn.bbsadminsys.domain.CommentsBean;
import com.example.wsn.bbsadminsys.domain.DeleListBean;

import java.util.List;

public interface CommentsDao {

    List<CommentsBean> getAllComments();
    String getToConent(int to_commt_id);
    List<CommentsBean> serchComments(String keywords);
    void delComment(int id);
    List<DeleListBean> getDeleList(int to_commt_id);
    void updateArt(int art_id);

}
