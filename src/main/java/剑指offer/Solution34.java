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
        while (left - 1 >= 0 && nums[left - 1] == target) {
            left--;
        }
        //right search
        while (right + 1< nums.length && nums[right + 1] == target) {
            right++;
        }
        res[0] = left ;
        res[1] = right;
        return res;
    }


    public static void main(String[] args) {
        int[] ints = {1,1,2};
        new Solution34().searchRange(ints, 1);
    }
}
