package com.xblzer.dp.singleton;

/**
 * lazy loading 懒汉式
 * 这种写法虽然达到了用的时候才初始化的目的，但是存在多线程获取实例时相互影响的问题
 * 可以用synchronized加锁，但是效率会降低
 * 在加锁的基础上再优化一下，减少加锁代码块的数量
 * @author 行百里者
 */
public class Singleton_5 {
    private static Singleton_5 INSTANCE;

    /**
     * 私有的构造方法，其他地方不能new
     */
    private Singleton_5() {
    }

    public static Singleton_5 getInstance() {
        if (INSTANCE == null) {
            //不在方法上加锁而在new的时候才加锁，减少锁的代码，然而这种方式并不行
            synchronized (Singleton_5.class) {
                // 测试，sleep一下，增加被其他线程打断的机会
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton_5();
            }
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
            new Thread(() -> System.out.println(Singleton_5.getInstance().hashCode())).start();
        }
    }
}
