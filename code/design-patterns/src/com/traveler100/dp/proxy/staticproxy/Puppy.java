package com.traveler100.dp.proxy.staticproxy;

import java.util.Random;

/**
 * @author chappell
 */
public class Puppy implements Painter {
    @Override
    public void paint() {
        System.out.println("小狗画梅花");
        //随机睡10s以内，假装这是处理业务逻辑
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
