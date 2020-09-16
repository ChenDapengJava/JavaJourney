package com.traveler100.dp.strategy;

import java.util.Comparator;

/**
 * @author 行百里者
 */
public class CarPriceComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        if (o1.price < o2.price) return -1;
        else if (o1.price > o2.price) return 1;
        return 0;
    }
}
