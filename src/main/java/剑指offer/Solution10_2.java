package 剑指offer;

/**
 * @Author: qihang
 * @Date: 2022/07/01/上午  11:22
 * @Description:
 */
public class Solution10_2 {
    class Solution {
        public int numWays(int n) {
            int[] fn = new int[101];
            fn[0] = 0;
            fn[1] = 1;
            fn[2] = 2;

            for (int i = 3; i <= n; i++) {
                fn[i] = (fn[i - 1] + fn[i - 2]) % 1000000007;
            }
            return fn[n];
        }
    }
}
