package pers.xblzer.tryout;

import pers.xblzer.tryout.agent.ObjectSizeAgent;

/**
 * @program: tryout
 * @description: 测试Object占用字节大小
 * @author: 行百里者
 * @create: 2020/11/03 14:43
 **/
public class ObjectSizeTest {
    public static void main(String[] args) {
//        // 配置 XX:+UseCompressedClassPointer XX:+UseCompressedOops
        // 16字节 = markword 8 + classpointer 4 + padding 4
        System.out.println("new Object size:" + ObjectSizeAgent.sizeOf(new Object()));
        // 16字节 = markword 8 + classpointer 4 + 数组长度 4 + padding 0（前面已经是8的倍数了）
        System.out.println("new array size:" + ObjectSizeAgent.sizeOf(new int[]{}));
        // 34+padding=40 （最终必须满足8的倍数）
        System.out.println("new a common class size:" + ObjectSizeAgent.sizeOf(new P()));

        // 配置 XX:-UseCompressedClassPointer XX:+UseCompressedOops
        // 16字节 = markword 8 + classpointer 8 + padding 0
//        System.out.println("new Object size:" + ObjectSizeAgent.sizeOf(new Object()));
//        // 24字节 = markword 8 + classpointer 8 + 数组长度 4 + padding 4（补齐至8的倍数）
//        System.out.println("new array size:" + ObjectSizeAgent.sizeOf(new int[]{}));
//        // 40 （最终必须满足8的倍数）
//        System.out.println("new a common class size:" + ObjectSizeAgent.sizeOf(new P()));
    }

    private static class P {
        // markword 8
        // ClassPinter 4 (-UseCompressedClassPointer时 为8；+UseCompressedClassPointer时 为4)

        // 4
        int id;
        // Oops 4
        String name;// 这是一个引用 +UseCompressedOops时 为8  -UseCompressedOops时 为4
        // 1
        byte b1;
        // 1
        byte b2;
        //Oops 4
        Object o;
        // 8
        long i;
    }
}
