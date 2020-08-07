package com.traveler100.dp.strategy;

import java.util.Comparator;

/**
 * @author 行百里者
 */
public class Context<T> {

    private Comparator comparator;

    public Context(Comparator comparator) {
        this.comparator = comparator;
    }

    public void sortWhatYouWant(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = this.comparator.compare(arr[i], arr[j]) > 0 ? j : minIndex;
            }
            T o = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = o;
        }
    }

    /*public void sortCar(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < cars.length; j++) {
                minIndex = cars[i].compareTo(cars[j]) > 0 ? j : minIndex;
            }
            Car c = cars[i];
            cars[i] = cars[minIndex];
            cars[minIndex] = c;
        }
    }

    public void sortSecurityMan(SecurityMan[] men) {
        for (int i = 0; i < men.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < men.length; j++) {
                minIndex = men[i].compareTo(men[j]) > 0 ? j : minIndex;
            }
            SecurityMan c = men[i];
            men[i] = men[minIndex];
            men[minIndex] = c;
        }
    }*/

}
