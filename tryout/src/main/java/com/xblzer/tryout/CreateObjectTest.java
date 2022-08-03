package com.xblzer.tryout;

import java.util.Arrays;

/**
 * @author 行百里者
 * @date 2022-08-03 10:48
 */
public class CreateObjectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //对象.getClass()
//        User user = new User();
//        Class clazz = user.getClass();
//        System.out.println(clazz.getPackage());
//        System.out.println(clazz.getName());
//        System.out.println(clazz.getCanonicalName());
//        System.out.println(clazz.getSimpleName());
        //类.class
//        Class clazz = User.class;
        //Class.forName
        Class clazz = Class.forName("com.xblzer.tryout.bean.User");
        System.out.println("getConstructors:");
        Arrays.stream(clazz.getConstructors()).iterator().forEachRemaining(System.out::println);
        System.out.println("getDeclaredFields:");
        Arrays.stream(clazz.getDeclaredFields()).iterator().forEachRemaining(System.out::println);
        System.out.println("getDeclaredMethods:");
        Arrays.stream(clazz.getDeclaredMethods()).iterator().forEachRemaining(System.out::println);
    }
}
