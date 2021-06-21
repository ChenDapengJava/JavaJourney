package pers.xblzer.algorithm.statckandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * @author chenpeng
 * @date 2021-06-20 19:44
 */
public class MyStackWithQueue<T> {
    private Queue<T> queue;
    private Queue<T> help;

    public MyStackWithQueue() {
        this.queue = new LinkedList<>();
        this.help = new LinkedList<>();
    }

    public void push(T value) {
        if (queue.isEmpty() && help.isEmpty()) {
            queue.add(value);
        }
        if (!queue.isEmpty()) {
            queue.add(value);
        }
        if (!help.isEmpty()) {
            help.add(value);
        }
    }

    public T pop() {
        Queue<T> temp = new LinkedList<>();
        if (!queue.isEmpty()) {
            temp = queue;
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
        } else if (!help.isEmpty()) {
            temp = help;
            while (help.size() > 1) {
                queue.add(help.poll());
            }
        }
        return temp.poll();
    }

    public static void main(String[] args) {
        MyStackWithQueue<Integer> q = new MyStackWithQueue();
        q.push(2);
        q.push(3);
        q.push(5);
        q.push(7);
        q.push(1);

        System.out.println(q.pop());
        System.out.println(q.pop());

        q.push(6);

        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}
