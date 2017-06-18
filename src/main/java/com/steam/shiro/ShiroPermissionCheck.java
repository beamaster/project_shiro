package com.steam.shiro;

import com.steam.util.ShiroUtil;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by steam on 2017/6/18.
 */
public class ShiroPermissionCheck {


    @Test
    public void checkPermission(){
        String configFile = "classpath:base_permission.ini";

//        String username = "jack";
//        String password = "123";
        String username = "tony";

        String password = "456";

        Subject currentSubject = ShiroUtil.login(configFile, username, password);
        currentSubject.checkPermission("login");

        System.out.println("蛤哈");

        currentSubject.logout();

    }


    @Test
    public void checkPermissions(){
        String configFile = "classpath:base_permission.ini";

//        String username = "jack";
//        String password = "123";
        String username = "tony";

        String password = "456";

        Subject currentSubject = ShiroUtil.login(configFile, username, password);
        currentSubject.checkPermissions("login","product","order");

        System.out.println("permissions");

        currentSubject.logout();
    }
}
