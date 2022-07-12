package com.xblzer.dp.singleton;

/**
 * 类加载的时候就实例化一个实例，JVM保证线程安全
 * 也称饿汉式
 * 该方式简单实用
 * @author 行百里者
 */
public class Singleton_1 {
    private static final Singleton_1 INSTANCE = new Singleton_1();

    /**
     * 私有的构造方法，其他地方不能new
     */
    private Singleton_1() {
    }

    public static Singleton_1 getInstance() {
        return INSTANCE;
    }

    /**
     * for test
     */
    public static void main(String[] args) {
        Singleton_1 instance1 = Singleton_1.getInstance();
        Singleton_1 instance2 = Singleton_1.getInstance();
        System.out.println(instance1 == instance2);
    }
}
