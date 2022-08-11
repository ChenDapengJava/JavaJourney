package com.xblzer.juc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 行百里者
 * @date 2022-08-05 10:29
 */
public class NiubilityContainer<T> {
    private List<T> list = new ArrayList<>();

    /**
     * add方法，借用list的add方法相容器添加元素
     * @param t 待添加的元素
     */
    public void add(T t) {
        list.add(t);
    }

    /**
     * 借助list的size方法返回当前容器的元素个数
     * @return int 容器元素个数
     */
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        NiubilityContainer c = new NiubilityContainer();
        //定义一个需要上锁的对象，线程持有该对象的锁才能执行
        final Object lock = new Object();

        //启动一个监控线程
        new Thread(() -> {
            System.out.println("监控线程启动...");
            synchronized (lock) {
                //只要元素个数不为5，就调用wait方法让出CPU
                if (c.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //通知添加元素的线程继续执行
                lock.notify();
            }
            System.out.println("容器元素个数为5，监控线程退出！");
        }, "MonitorThread").start();

        //启动一个添加元素的线程
        new Thread(() -> {
            System.out.println("添加元素线程启动...");
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    c.add(i);
                    System.out.println("添加元素线程 add " + i);

                    if (c.size() == 5) {
                        //先唤醒当前线程
                        lock.notify();
                        try {
                            //释放锁，使得监控线程得以执行
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "AddThread").start();
    }
}
