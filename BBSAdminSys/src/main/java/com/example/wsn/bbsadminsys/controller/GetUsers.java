package com.example.wsn.bbsadminsys.controller;
/*
 *project:JavaCode
 *file:GetUsers
 *@author:wsn
 *date:2021/5/15 14:20
 */


import com.example.wsn.bbsadminsys.dao.GetAllUsersDao;
import com.example.wsn.bbsadminsys.domain.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class GetUsers {

    @Autowired
    GetAllUsersDao getAllUsersDao;
    @RequestMapping("/getall")
    public List<UserBean> getAllUsers(){

        return getAllUsersDao.getAllusers();
    }
}
