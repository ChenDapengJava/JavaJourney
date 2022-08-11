package cn.chendapeng.juc;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author 行百里者
 * @date 2022-08-05 10:33
 */
public class TestCountDownLatch {

    static CountDownLatch latch = new CountDownLatch(1);
    static List lists = new LinkedList();


    static void add(Object o) {
        lists.add(o);
    }

    static int size() {
        return lists.size();
    }

    static class ReactThread extends Thread {
        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
                    latch.countDown();
                }

                //（监控线程已经准备打印退出了，添加元素的线程还在继续添加）
                //加个睡眠时间，方便观察，因为打印的动作也需要耗时
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ReactThread().start();
        new AddThread().start();
    }
}
