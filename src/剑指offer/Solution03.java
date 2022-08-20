package 剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: qihang
 * @Date: 2022/06/29/上午  10:36
 * @Description:
 */
public class Solution03 {
}

class Solution {
    public int findRepeatNumber(int[] nums) {
//        List<Integer> sortNums = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
//
//        int pre = sortNums.get(0);
//
//        for (int i = 1; i < sortNums.size(); i++) {
//            int curNum = sortNums.get(i);
//            if (curNum == pre) {
//                return pre;
//            }
//            pre = curNum;
//        }
//        return -1;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] test = new int[]{3, 4, 2, 0, 0, 1};
        new Solution().findRepeatNumber(test);
    }
}
