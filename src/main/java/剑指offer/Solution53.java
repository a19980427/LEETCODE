package 剑指offer;

import java.util.Arrays;

/**
 * @author qihang
 * @create 2022-08-24 下午  12:20
 */
public class Solution53 {
    public int search(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        int count = 0;
        if (i >= 0) {
            count++;
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && nums[left] == target) {
                left--;
                count++;
            }
            while (right < nums.length && nums[right] == target) {
                right++;
                count++;
            }
        }
        return count;
    }
}