package 剑指offer;

import java.util.ArrayList;

/**
 * @author qihang
 * @create 2022-07-18 下午  04:38
 */
public class Solution17 {
    class Solution {
        public int[] printNumbers(int n) {
            ArrayList<Integer> res = new ArrayList<>((int) Math.pow(10, n));
            for (int i = 1; i < Math.pow(10, n); i++) {
                res.add(i);
            }
            return res.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
