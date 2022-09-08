package 剑指offer;

/**
 * @author qihang
 * @create 2022-08-28 下午  04:57
 */
public class Offer63 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;

        for (int price : prices) {
            res = Math.max(res, price - min);
            min = Math.min(min, price);
        }
        return res;
    }
}
