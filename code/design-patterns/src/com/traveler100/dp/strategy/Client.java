package com.traveler100.dp.strategy;

import java.util.Arrays;

/**
 * @author 行百里者
 */
public class Client {

    public static void main(String[] args) {
//        Context ctx = new Context();
//
        Car[] cars = {new Car(18, 55), new Car(12, 40), new Car(25, 60)};
//        ctx.sortCar(cars);
//        System.out.println(Arrays.toString(cars));
//
        SecurityMan[] men = {new SecurityMan(10, 95), new SecurityMan(6, 92), new SecurityMan(8, 97)};
//        ctx.sortSecurityMan(men);
//        System.out.println(Arrays.toString(men));

//        Context ctx = new Context(new CarCapacityComparator());
        Context ctx = new Context(new SecurityManBeautyComparator());
        ctx.sortWhatYouWant(men);
        System.out.println(Arrays.toString(men));
    }
}
