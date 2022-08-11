package cn.chendapeng.juc;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author 行百里者
 * @date 2022-08-05 11:13
 */
public class TestSemaphore {
    static List lists = new LinkedList();

    static void add(Object o) {
        lists.add(o);
    }

    static int size() {
        return lists.size();
    }

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        //定义一个只能有1个线程能获得许可的信号量
        Semaphore semaphore = new Semaphore(1);

        t1 = new Thread(() -> {
            try {
                //尝试获得许可
                semaphore.acquire();
                //添加5个元素之后，释放锁
                for (int i = 0; i < 5; i++) {
                    add(new Object());
                    System.out.println("线程t1 已经 add " + size() + " 个元素");
                }
                //释放锁，等待t2打印退出
                semaphore.release();

                //需要让t2执行
                t2.start();
                t2.join();

                //t2退出后，继续获得许可，添加元素
                semaphore.acquire();
                for (int i = 0; i < 5; i++) {
                    add(new Object());
                    System.out.println("线程t1 已经 add " + size() + " 个元素");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2 = new Thread(() -> {
            try {
                //首先获得许可
                semaphore.acquire();
                //打印 退出
                System.out.println("------- 线程t2已知容器中有5个元素了，t2退出。-------");
                //释放锁，等t1接着添加剩余的元素
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
    }
}
