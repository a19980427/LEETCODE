package 剑指offer;

/**
 * @Author: qihang
 * @Date: 2022/07/01/上午  11:13
 * @Description:
 */
public class Solution10 {
    class Solution {
        public int fib(int n) {
            int[] fibo = new int[101];
            fibo[0] = 0;
            fibo[1] = 1;

            for (int i = 2; i <= n; i++) {
                fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000007;
            }
            return fibo[n];
        }
    }
}
