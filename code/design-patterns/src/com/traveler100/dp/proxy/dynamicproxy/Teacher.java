package com.traveler100.dp.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * 使用jdk的动态代理
 * @author 行百里者
 */
public class Teacher {
    public static void main(String[] args) {
        Pony pony = new Pony();
        //将proxy内部调用invoke方法 生成的中间类 保存下来
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Painter painter = (Painter) Proxy.newProxyInstance(
                Pony.class.getClassLoader(),
                new Class[]{Painter.class},
                new TimeProxyHandler(pony));
        painter.paint();
    }
}
