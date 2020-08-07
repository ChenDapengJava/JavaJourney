package com.traveler100.dp.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * cglib-code generate library
 * cglib实现动态代理不需要实现接口
 * 底层用的也是asm
 * @author 行百里者
 */
public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Pony.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Pony pony = (Pony) enhancer.create();
        pony.paint();
    }
}

class TimeMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(o.getClass().getSuperclass().getName());
        System.out.println("before...");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return result;
    }
}

class Pony {
    public void paint() {
        System.out.println("小马画月牙");
        //随机睡10s以内，假装这是处理业务逻辑
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
