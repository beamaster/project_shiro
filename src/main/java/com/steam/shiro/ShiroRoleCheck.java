package com.steam.shiro;

import com.steam.util.ShiroUtil;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;

/** 角色测试
 * Created by steam on 2017/6/18.
 */
public class ShiroRoleCheck {


    @Test
    public void checkRole(){
        String configFile = "classpath:base_role.ini";

//        String username = "jack";
//        String password = "123";
        String username = "tony";

        String password = "456";

        Subject currentSubject = ShiroUtil.login(configFile, username, password);
         currentSubject.checkRole("administrator");

        System.out.println("good");
        currentSubject.logout();
    }


    @Test
    public void checkRoles(){
        String configFile = "classpath:base_role.ini";

//        String username = "jack";
//        String password = "123";
        String username = "tony";

        String password = "456";

        Subject currentSubject = ShiroUtil.login(configFile, username, password);
        currentSubject.checkRoles(Arrays.asList("loginAdmin","productAdmin","orderAdmin"));
        currentSubject.checkRoles("loginAdmin","productAdmin","orderAdmin");

        System.out.println("非登管");
        System.out.println("非产管");

        currentSubject.logout();
    }
}
