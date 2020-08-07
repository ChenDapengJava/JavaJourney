package com.traveler100.dp.singleton;

/**
 * lazy loading 懒汉式
 * 这种写法虽然达到了用的时候才初始化的目的，但是存在多线程获取实例时相互影响的问题
 * 可以用synchronized加锁，但是效率会降低
 * @author traveler100
 */
public class Singleton_4 {
    private static Singleton_4 INSTANCE;

    /**
     * 私有的构造方法，其他地方不能new
     */
    private Singleton_4() {
    }

    /**
     * 既然lazy loading的写法有线程安全问题，那就加把锁
     */
    public static synchronized Singleton_4 getInstance() {
        if (INSTANCE == null) {
            // 测试，sleep一下，增加被其他线程打断的机会
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton_4();
        }
        return INSTANCE;
    }

    /**
     * for test
     */
    public static void main(String[] args) {
        //同一个类的不同对象的hashcode不同
        //跑100个线程，看看有没有不同的实例
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton_4.getInstance().hashCode())).start();
        }
    }
}
