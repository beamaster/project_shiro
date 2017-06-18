package com.steam.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created by steam on 2017/6/18.
 */
public class ShiroUtil {

    public static Subject login(String configFile,String username,String password){

        //1.加载shiro配置文件,初始化SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
        //2.获取SecurityManager实例
        SecurityManager instance = factory.getInstance();
        //3.把实例instance绑定到SecurityUtils上
        SecurityUtils.setSecurityManager(instance);
        //4.得到当前用户
        Subject subject = SecurityUtils.getSubject();
        //5.创建简单tonken令牌(用户名/密码 形式）
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            //6.登陆验证
            subject.login(token);
            System.out.println("ok...");
        }catch (AuthenticationException e){
            e.printStackTrace();
            System.out.println("fail");
        }
        //7.返回当前用户subject,实际调用login验证后退出
        return subject;
    }
}
