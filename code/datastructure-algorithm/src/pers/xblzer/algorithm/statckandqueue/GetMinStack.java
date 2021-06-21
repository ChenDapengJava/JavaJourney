package pers.xblzer.algorithm.statckandqueue;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能
 * 1）pop、push、getMin操作的时间复杂度都是 O(1)。
 * 2）设计的栈类型可以使用现成的栈结构。
 * @author 行百里er
 * @date 2021-06-18 17:29
 */
public class GetMinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public GetMinStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("栈空");
        }
        //取出栈顶的值
        return minStack.peek();
    }

    //入栈，如果插入的数小于最小值栈的栈顶元素，那么把它也压入的minStack的栈顶，否则压入minStack的最小值到栈顶
    public void push(int value) {
        //minStack.push(Math.min(value, getMin()));
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {
            minStack.push(Math.min(value, getMin()));
        }
        dataStack.push(value);
    }

    //出栈，同时minStack也弹出栈顶，保持与dataStack元素个数一致
    public int pop() {
        if (dataStack.isEmpty()) {
            System.out.println("栈空！");
        }
        minStack.pop();
        return dataStack.pop();
    }

    public static void main(String[] args) {
        GetMinStack stack = new GetMinStack();
        stack.push(3);
        stack.push(5);
        stack.push(6);
        stack.push(2);
        stack.push(7);
        stack.push(3);

        System.out.println(stack.getMin());

        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }

}
