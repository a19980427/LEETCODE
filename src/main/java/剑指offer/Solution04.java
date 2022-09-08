package 剑指offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: qihang
 * @Date: 2022/06/30/上午  10:39
 * @Description:
 */
public class Solution04 {
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            List<List<Integer>> collect = Arrays.stream(matrix).map(l -> Arrays.stream(l)
                    .boxed().collect(Collectors.toList())).collect(Collectors.toList());

            Integer tar = Integer.valueOf(target);
            for (int i = 0; i < collect.size(); i++) {
                int index = Collections.binarySearch(collect.get(i), tar);
                if (index >= 0) {
                    return true;
                }
            }
            return false;
        }
    }
}


