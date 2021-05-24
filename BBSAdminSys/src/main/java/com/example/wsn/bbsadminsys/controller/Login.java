package com.example.wsn.bbsadminsys.controller;
/*
 *project:JavaCode
 *file:Hello
 *@author:wsn
 *date:2021/5/14 20:43
 */


import com.example.wsn.bbsadminsys.dao.GetAllUsersDao;
import com.example.wsn.bbsadminsys.domain.UserBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class Login {

    @Autowired
    GetAllUsersDao getAllUsersDao;

    @RequestMapping("/bbsadmin")
    public String toIndex(){
        return "/main";
    }
    @RequestMapping("/login")
    public String login(){
        return "/index.html";
    }
    @RequestMapping (value = "/hello",method = {RequestMethod.GET,RequestMethod.POST})
    public String login(String username, String password, HttpSession session){
        UserBean user=null;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            return "redirect:/main";
        }catch (UnknownAccountException | IncorrectCredentialsException e){
            return "redirect:/login";
        }

    }
    @RequestMapping("/main")
    public String toMain(){
        return "/main.html";
    }
    @RequestMapping("/unauthorized")
    public String toUn(){
        return "/unauthorized.html";
    }
}
