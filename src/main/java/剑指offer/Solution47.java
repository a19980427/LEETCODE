package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qihang
 * @create 2022-08-21 下午  11:57
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        boolean[] visited = new boolean[nums.length];
        search(res, new int[nums.length], nums, 0, new HashSet<>(), visited);
        return res;
    }

    private void search(List<List<Integer>> res, int[] temp, int[] nums, int curIndex, HashSet<String> hashSet, boolean[] visited) {
        if (curIndex == nums.length) {
            if (!hashSet.contains(Arrays.toString(temp))) {
                hashSet.add(Arrays.toString(temp));
                res.add(Arrays.stream(temp).boxed().collect(Collectors.toList()));
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    temp[curIndex] = nums[i];
                    search(res, temp, nums, curIndex + 1, hashSet, visited);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {

        new Solution47().permuteUnique(new int[]{1, 1, 2});
    }
}



