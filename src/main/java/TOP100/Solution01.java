package TOP100;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: qihang
 * @Date: 2022/06/15/下午  03:56
 * @Description:
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        List<Integer> list = Arrays.stream(nums.clone()).boxed().collect(Collectors.toList());
        Arrays.sort(nums);
        while (nums[left] + nums[right] != target) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right -= 1;
            } else {
                left += 1;
            }
        }

        final int i = list.indexOf(nums[left]);
        final int j = list.lastIndexOf(nums[right]);

        return new int[]{i, j};
    }
}
