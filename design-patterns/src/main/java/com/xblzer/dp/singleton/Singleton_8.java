package com.xblzer.dp.singleton;

/**
 * 枚举单例
 * 不仅可以解决线程同步，还可以防止反序列化
 * @author travler100
 */
public enum Singleton_8 {
    INSTANCE;

    /**
     * for test
     */
    public static void main(String[] args) {
        //同一个类的不同对象的hashcode不同
        //跑100个线程，看看有没有不同的实例
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton_8.INSTANCE.hashCode())).start();
        }
    }
}
