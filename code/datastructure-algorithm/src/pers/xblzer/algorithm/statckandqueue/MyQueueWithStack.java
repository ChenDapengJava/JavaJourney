package pers.xblzer.algorithm.statckandqueue;

import java.util.Stack;

/**
 * 用栈实现队列
 * @author chenpeng
 * @date 2021-06-21 11:42
 */
public class MyQueueWithStack {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public MyQueueWithStack() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void pushToPop() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    public void add(int value) {
        pushStack.push(value);
        pushToPop();
    }

    public int poll() {
        if (popStack.isEmpty()) {
            throw new RuntimeException("队列空了");
        }
        int result = popStack.pop();
        pushToPop();
        return result;
    }

    public static void main(String[] args) {
        MyQueueWithStack q = new MyQueueWithStack();
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        System.out.println(q.poll());
        System.out.println(q.poll());

        q.add(7);

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());

    }
}
