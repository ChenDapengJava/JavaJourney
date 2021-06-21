package pers.xblzer.algorithm.statckandqueue;

/**
 * @author 行百里er
 * @date 2021-06-15 10:35
 */
public class QueueAndStackWithArray {

    public static class MyStack {
        private int[] array;
        private int index;

        public MyStack(int size) {
            this.array = new int[size];
        }

        //入栈
        public void push(int value) {
            if (index >= array.length) {
                throw new RuntimeException("栈满，不让加了");
            }
            array[index++] = value;
        }

        //出栈
        public int pop() {
            if (index <= 0) {
                throw new RuntimeException("栈空，不能取出");
            }
            return array[--index];
        }

    }

    public static class MyQueue {
        private int[] array;
        private int begin;
        private int end;
        private int size;

        public MyQueue (int limit) {
            this.array = new int[limit];
            this.begin = 0;
            this.end = 0;
            this.size = 0;
        }

        public void push (int value) {
            size++;
            if (size > array.length) {
                throw new RuntimeException("队列满了");
            }
            array[end] = value;
            end++;
            //针对end越界的处理
            if (end >= array.length) {
                end = 0;
            }
        }

        public int pop () {
            size--;
            if (size < 0) {
                throw new RuntimeException("队列已空");
            }
            int result = array[begin];
            begin++;
            //针对begin越界的处理
            if (begin >= array.length) {
                begin = 0;
            }
            return result;
        }
    }

    public static void main(String[] args) {
//        MyStack stack = new MyStack(5);
//        stack.push(5);
//        stack.push(6);
//        stack.push(4);
//        stack.push(3);
//        stack.push(7);
////        stack.push(9);
////        stack.push(10);
//
//        for (int i = 0; i < 6; i++) {
//            System.out.println(stack.pop());
//        }

        MyQueue queue = new MyQueue(5);
        for (int i = 0; i < 5; i++) {
            queue.push(i);
        }

        System.out.println("取出一个数：" + queue.pop());
        System.out.println("添加数据");
        queue.push(16);
        //queue.push(17);
        System.out.println("添加成功，size：" + queue.size);

        System.out.println("弹出数据：");
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.pop());
        }
    }
}
