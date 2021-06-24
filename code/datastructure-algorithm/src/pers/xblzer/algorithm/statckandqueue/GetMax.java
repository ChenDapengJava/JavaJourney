package pers.xblzer.algorithm.statckandqueue;

/**
 * 递归简单case
 * @author 行百里er
 * @date 2021-06-23 22:51
 */
public class GetMax {
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        //base case
        if (L == R) {
            return arr[L];
        }
        int mid = (L + R) >> 1;
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 12, 26, 9, 10, 3, 17};
        System.out.println(getMax(arr));
    }
}
