package 剑指offer;

import java.util.Arrays;

/**
 * @author qihang
 * @create 2022-08-23 下午  12:05
 */
public class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
}