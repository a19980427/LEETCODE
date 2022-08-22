package 剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qihang
 * @create 2022-08-22 下午  03:56
 */
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();


        // x scan
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    xSet.add(i);
                    ySet.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (xSet.contains(i) || ySet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}