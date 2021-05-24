package com.example.wsn.bbsadminsys.config;
/*
 *project:JavaCode
 *file:ShiroConfig
 *@author:wsn
 **date:2021/5/24 14:25
 */

import com.example.wsn.bbsadminsys.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String,String> filtermap=new LinkedHashMap<>();
        filtermap.put("/index.html","anon");
//        filtermap.put("/static/**","anon");
        filtermap.put("/bbsadmin","authc");
        filtermap.put("/main.html","authc");
        filtermap.put("/main","perms[admin]");
//        filtermap.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filtermap);
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        shiroFilterFactoryBean.setLoginUrl("/login");
        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
