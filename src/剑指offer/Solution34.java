package 剑指offer;

import java.util.Arrays;

/**
 * @author qihang
 * @create 2022-08-20 下午  11:32
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if (i < 0) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        // left search
        int left = i;
        int right = i;
        while (left > 0 && nums[left] == target) {
            left--;
        }
        //right search
        while (right < nums.length && nums[right] == target) {
            right++;
        }
        res[0] = left + 1;
        res[1] = right - 1;
        return res;
    }


    public static void main(String[] args) {
        int[] ints = {5, 7, 7, 8, 8, 10};
        new Solution34().searchRange(ints, 6);
    }
}
