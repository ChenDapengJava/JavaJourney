package pers.xblzer.algorithm.statckandqueue;

/**
 * @author 行百里er
 * @date 2021-06-23 20:07
 */
public class Test {
    public static void main(String[] args) {
        int L = 10;
        int R = 19;
        int mid = (L + R) >> 1;
        System.out.println(mid);
    }

    public static int getMid(int L, int R) {
        int mid = (L + R) >> 1;
        return mid;
    }
}
