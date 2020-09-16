package com.traveler100.dp.proxy.springaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring AOP
 * @author 行百里者
 */
public class Teacher {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app_aop.xml");
        Pony pony = (Pony) ctx.getBean("pony");
        pony.paint();
    }
}
