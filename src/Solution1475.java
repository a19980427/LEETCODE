/**
 * @author qihang
 * @create 2022-09-01 上午  10:50
 */
public class Solution1475 {
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            res[i] = prices[i];
            for (int j = i; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    res[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return res;

        /**
         * int n = prices.length;
         *         int[] ans = new int[n];
         *         Deque<Integer> stack = new ArrayDeque<Integer>();
         *         for (int i = n - 1; i >= 0; i--) {
         *             while (!stack.isEmpty() && stack.peek() > prices[i]) {
         *                 stack.pop();
         *             }
         *             ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
         *             stack.push(prices[i]);
         *         }
         *         return ans;
         */
    }

    public static void main(String[] args) {
        new Solution1475().finalPrices(new int[]{8, 4, 6, 2, 3});

    }
}
