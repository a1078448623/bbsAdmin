package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:TypesDao
 *@author:wsn
 *date:2021/5/18 11:20
 */

import com.example.wsn.bbsadminsys.domain.ArtTypeDao;
import com.example.wsn.bbsadminsys.domain.TypeNames;

import java.util.List;

public interface TypesDao {

    List<TypeNames> getAllType();
    boolean changeFname(String oldname,String newname);
    void changeCname(int t_id,String newname);
    String getFname(int t_id);
    void delArtDueToType(int t_id);
    List<ArtTypeDao> getTypeArt(int t_id);
    void delChildType(int t_id);
    List<TypeNames> getFaCh(String fname);
    void addNewType(String childname,String fathername);
    void updateImgName(int t_id,String filename);
}
