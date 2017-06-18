package com.steam.shiro;

import com.steam.util.ShiroUtil;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by steam on 2017/6/18.
 */
public class ShiroPermissionTest {


    @Test
    public void isPermitted(){
        String configFile = "classpath:base_permission.ini";

//        String username = "jack";
//        String password = "123";
        String username = "tony";

        String password = "456";

        Subject currentSubject = ShiroUtil.login(configFile, username, password);
        boolean result1 = currentSubject.isPermitted("login");
        boolean result2 = currentSubject.isPermitted("order");


        System.out.println(result1?"有登陆操作":"禁止登陆");
        System.out.println(result2?"有订单操作":"无权限查看订单");



        currentSubject.logout();
    }


    @Test
    public void isPermittedAll(){
        String configFile = "classpath:base_permission.ini";

//        String username = "jack";
//        String password = "123";
        String username = "tony";

        String password = "456";

        Subject currentSubject = ShiroUtil.login(configFile, username, password);

        boolean results = currentSubject.isPermittedAll("order","login");

        System.out.println(results?"都有权限":"不全有权限");

        currentSubject.logout();
    }

}
