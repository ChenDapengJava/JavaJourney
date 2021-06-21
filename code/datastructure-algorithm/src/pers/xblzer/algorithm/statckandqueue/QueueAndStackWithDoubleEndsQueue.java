package pers.xblzer.algorithm.statckandqueue;

/**
 * 双向链表实现双端队列
 * 用双端队列实现队列和栈
 *
 * @author 行百里er
 * @date 2021-06-11 8:48
 */
public class QueueAndStackWithDoubleEndsQueue {

    /**
     * 定义双向链表
     * @param <T>
     */
    public static class Node<T> {
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * 用双向链表实现双端队列
     * @param <T>
     */
    public static class DoubleEndsQueue<T> {
        private Node<T> head;
        private Node<T> tail;

        public boolean isEmpty() {
            return head == null;
        }

        /**
         * 从前端插入数据
         * tail位置不变，只需移动head
         * @param value 要插入的数据
         */
        public void pushFromHead(T value) {
            //先将插入的数据封装一个双向链表结点，然后考虑把它挂在队列的哪个地方（指针指向问题）
            Node<T> cur = new Node<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        /**
         * 从尾部取数
         * @return 取数的数
         */
        public T popFromTail() {
            if (head == null) {
                System.out.println("队列空了");
                return null;
            }
            //从尾部取数，定义一个当前结点变量保存tail
            Node<T> cur = tail;
            if (head == tail) {
                //只有一个元素，取出之后，都指向空
                head = null;
                tail = null;
            } else {
                //移动tail
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }

            return cur.value;
        }

        /**
         * 从尾部添加
         * @param value 待添加数据
         */
        public void pushFromTail(T value) {
            Node<T> cur = new Node<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                //从尾部添加，移动tail
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
        }

        /**
         * 从头部取数
         * @return 取出的数据
         */
        public T popFromHead() {
            if (head == null) {
                System.out.println("队列空了");
                return null;
            }
            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
                cur.next = null;
            }
            return cur.value;
        }
    }

    public static class MyQueue<T> {
        private DoubleEndsQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndsQueue<>();
        }

        //入队列
        public void push(T value) {
            queue.pushFromTail(value);
        }

        //出队列
        public T poll() {
            return queue.popFromHead();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static class MyStack<T> {
        private DoubleEndsQueue<T> queue;

        public MyStack() {
            queue = new DoubleEndsQueue<>();
        }

        //入栈
        public void push(T value) {
            queue.pushFromTail(value);
        }

        //出栈
        public T pop() {
            return queue.popFromTail();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.push(2);
        myQueue.push(5);
        myQueue.push(9);
        myQueue.push(2);
        myQueue.push(7);
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.poll());
        }
        System.out.println("===========================");
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(2);
        myStack.push(5);
        myStack.push(9);
        myStack.push(2);
        myStack.push(7);
        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
    }
}
