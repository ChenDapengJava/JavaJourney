package com.traveler100.dp.singleton;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类---也可实现懒加载
 * @author traveler100
 */
public class Singleton_7 {

    /**
     * 私有的构造方法，其他地方不能new
     */
    private Singleton_7() {
    }

    /**
     * 定义一个静态内部类
     */
    private static class SingletonHolder {
        private static final Singleton_7 INSTANCE = new Singleton_7();
    }

    public static Singleton_7 getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * for test
     */
    public static void main(String[] args) {
        //同一个类的不同对象的hashcode不同
        //跑100个线程，看看有没有不同的实例
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton_7.getInstance().hashCode())).start();
        }
    }
}
