package 剑指offer;

/**
 * @author qihang
 * @create 2022-08-24 下午  12:28
 */
public class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;

        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum == target) {
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{nums[left], nums[right]};
    }
}