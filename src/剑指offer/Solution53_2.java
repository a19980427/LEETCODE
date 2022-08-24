package 剑指offer;

/**
 * @author qihang
 * @create 2022-08-24 下午  12:24
 */
public class Solution53_2 {
    public int missingNumber(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num != count) {
                return count;
            }
            count++;
        }
        return count;
    }
}