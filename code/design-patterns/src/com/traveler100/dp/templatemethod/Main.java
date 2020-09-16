package com.traveler100.dp.templatemethod;

/**
 * 模板方法设计模式
 * 范式重写的方法，系统帮我们自动调用的
 * 都可以称之为模板方法
 * @author 行百里者
 */
public class Main {
    public static void main(String[] args) {
        Animal pony = new Pony();
        pony.metabolism();
        System.out.println("------------------------");
        Animal calf = new Calf();
        calf.metabolism();
    }
}

abstract class Animal {
    /**
     * 新陈代谢
     * 假设都需要经过吃、喝、睡
     */
    public void metabolism() {
        eat();
        drink();
        sleep();
    }

    abstract void eat();

    abstract void drink();

    abstract void sleep();
}

class Pony extends Animal {
    @Override
    void eat() {
        System.out.println("Pony eating");
    }

    @Override
    void drink() {
        System.out.println("Pony drinking");
    }

    @Override
    void sleep() {
        System.out.println("Pony sleeping");
    }
}

class Calf extends Animal {
    @Override
    void eat() {
        System.out.println("Calf eating");
    }

    @Override
    void drink() {
        System.out.println("Calf drinking");
    }

    @Override
    void sleep() {
        System.out.println("Calf sleeping");
    }
}