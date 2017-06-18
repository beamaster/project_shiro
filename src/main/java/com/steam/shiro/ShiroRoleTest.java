package com.steam.shiro;

import com.steam.util.ShiroUtil;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;


/**
 * Created by steam on 2017/6/18.
 */
public class ShiroRoleTest {


    @Test
    public void hasRole(){
        String configFile = "classpath:base_role.ini";

//        String username = "jack";
//        String password = "123";
        String username = "tony";

        String password = "456";

        Subject currentSubject = ShiroUtil.login(configFile, username, password);
        boolean result = currentSubject.hasRole("administrator");

        System.out.println(result?"超级管理员":"非超管");
        currentSubject.logout();
    }


    @Test
    public void hasRoles(){
        String configFile = "classpath:base_role.ini";

//        String username = "jack";
//        String password = "123";
        String username = "tony";

        String password = "456";

        Subject currentSubject = ShiroUtil.login(configFile, username, password);
        boolean[] results = currentSubject.hasRoles(Arrays.asList("loginAdmin","productAdmin","orderAdmin"));

        System.out.println(results[0]?"登陆管理员":"非登管");
        System.out.println(results[1]?"产品管理员":"非产管");
        System.out.println(results[2]?"订单管理员":"非订管");
        currentSubject.logout();
    }

    @Test
    public void hasAllRoles(){
        String configFile = "classpath:base_role.ini";

        String username = "jack";
        String password = "123";

//        String username = "tony";
//        String password = "456";

        Subject currentSubject = ShiroUtil.login(configFile, username, password);
        boolean result = currentSubject.hasAllRoles(Arrays.asList("loginAdmin","productAdmin","orderAdmin"));

        System.out.println(result?"都有":"非都有");
        currentSubject.logout();
    }
}
