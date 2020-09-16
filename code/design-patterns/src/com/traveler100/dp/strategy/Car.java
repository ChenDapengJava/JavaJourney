package com.traveler100.dp.strategy;

/**
 * 汽车 类
 * @author 行百里者
 */
public class Car implements Comparable<Car> {

    //价格
    int price;
    //油箱容量
    int capacity;

    public Car(int price, int capacity) {
        this.price = price;
        this.capacity = capacity;
    }

    @Override
    public int compareTo(Car c) {
        if (this.price < c.price) {
            return -1;
        }
        if (this.price > c.price) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", capacity=" + capacity +
                '}';
    }
}
