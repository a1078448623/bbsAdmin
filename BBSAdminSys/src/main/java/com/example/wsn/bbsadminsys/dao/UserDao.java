package com.example.wsn.bbsadminsys.dao;
/*
 *project:JavaCode
 *file:UserDao
 *@author:wsn
 **date:2021/5/24 15:38
 */

import com.example.wsn.bbsadminsys.domain.UserBean;

public interface UserDao {
    UserBean getUser(String username);
}
