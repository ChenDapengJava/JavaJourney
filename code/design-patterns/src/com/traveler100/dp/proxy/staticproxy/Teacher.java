package com.traveler100.dp.proxy.staticproxy;

/**
 * @author chappell
 */
public class Teacher {
    public static void main(String[] args) {
        //new TimeProxy(new Puppy()).paint();
        new TimeProxy(new LogProxy(new Puppy())).paint();
    }
}
