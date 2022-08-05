package com.xblzer.juc;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author chenpeng
 * @date 2022-08-05 10:30
 */
public class TestCyclicBarrier {

    static CyclicBarrier barrier ;
    static List lists = new LinkedList();


    static void add(Object o) {
        lists.add(o);
    }

    static int size() {
        return lists.size();
    }

    static class ReactThread implements Runnable {
        @Override
        public void run() {
            System.out.println("============== 元素个数已到达5，监控退出！=============");
        }
    }

    static class AddThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i < 11; i++) {
                add(new Object());
                System.out.println("添加元素线程 add 第" + i + "个元素");

                if (size() == 5) {
                    try {
                        barrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        barrier = new CyclicBarrier(1, new ReactThread());
        new AddThread().start();
    }
}
