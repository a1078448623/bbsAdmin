package com.example.wsn.bbsadminsys.realm;
/*
 *project:JavaCode
 *file:UserRealm
 *@author:wsn
 **date:2021/5/24 14:38
 */

import com.example.wsn.bbsadminsys.dao.UserDao;
import com.example.wsn.bbsadminsys.domain.UserBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserDao userDao;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject= SecurityUtils.getSubject();
        UserBean currentUser = (UserBean) subject.getPrincipal();
        if("admin".equals(currentUser.getUsername())){
            info.addStringPermission("admin");
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserBean user = userDao.getUser(token.getUsername());

        if(user==null) return null;
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");


    }
}
