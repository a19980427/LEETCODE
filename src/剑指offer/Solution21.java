package 剑指offer;

/**
 * @author qihang
 * @create 2022-08-06 下午  02:23
 */
public class Solution21 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (left < nums.length && nums[left] % 2 == 1) {
                left++;
            }
            while (right >= 0 && nums[right] % 2 == 0) {
                right--;
            }
            if (left < nums.length && right >= 0 && left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 11, 14};
        new Solution21().exchange(nums);
    }
}