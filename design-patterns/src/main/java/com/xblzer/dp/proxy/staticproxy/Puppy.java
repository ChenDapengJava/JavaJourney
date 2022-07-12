package com.xblzer.dp.proxy.staticproxy;

import java.util.Random;

/**
 * @author 行百里者
 * @since 2020.5.22
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
