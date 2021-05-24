package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:CommonDao
 *@author:wsn
 *date:2021/5/16 13:25
 */

import com.example.wsn.bbsadminsys.domain.Statistics;
import com.example.wsn.bbsadminsys.domain.TypeNum;

import java.util.List;

public interface CommonDao {
    public Statistics getStas();
    List<TypeNum> getGenderNums();
    List<TypeNum> getWeekNums(int type);
    void addVisit();
}
