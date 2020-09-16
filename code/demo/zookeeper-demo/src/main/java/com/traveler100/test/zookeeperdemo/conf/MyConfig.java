package com.traveler100.test.zookeeperdemo.conf;

/**
 * @program: demo
 * @description: 自定义配置，根据实际业务自定义
 * @author: 行百里者
 * @create: 2020/09/16 10:28
 **/
public class MyConfig {

    private String userServiceIP;

    public String getUserServiceIP() {
        return userServiceIP;
    }

    public void setUserServiceIP(String userServiceIP) {
        this.userServiceIP = userServiceIP;
    }
}
