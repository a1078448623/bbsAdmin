package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:EliteTopDao
 *@author:wsn
 **date:2021/5/21 9:04
 */

import com.example.wsn.bbsadminsys.domain.AllArtsBean;
import com.example.wsn.bbsadminsys.domain.Statistics;

import java.util.List;

public interface EliteTopDao {
    void addElite(int id);
    void addTop(int id);
    List<AllArtsBean> getAllEliteTop();
    Statistics getLimits();
    void cancelElite(int art_id);
    void cancelTop(int art_id);
    void editEliteLimit(int value);
    void editTopLimit(int value);
    int getEliteNum(int art_id);
    int getTopNum(int art_id);
}
