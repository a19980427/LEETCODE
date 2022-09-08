package 剑指offer;

import java.util.Arrays;

/**
 * @author qihang
 * @create 2022-08-23 上午  11:35
 */
public class Solution39 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2 ];
    }

    public static void main(String[] args) {
        new Solution39().majorityElement(new int[]{3, 2, 3});
    }
}