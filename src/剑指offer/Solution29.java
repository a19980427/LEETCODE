package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qihang
 * @create 2022-08-22 下午  01:10
 */
public class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int height = matrix.length;
        int width = matrix[0].length;
        search(0, matrix, height, width, res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void search(int step, int[][] matrix, int height, int width, List<Integer> res) {
        int x0 = step;
        int y0 = step;
        int x1 = height - step - 1;
        int y1 = width - step - 1;

        if (x0 > x1 || y0 > y1) {
            return;
        }

        // 右
        for (int i = y0; i <= y1; i++) {
            res.add(matrix[x0][i]);
        }

        // 下
        for (int i = x0 + 1; i <= x1; i++) {
            res.add(matrix[i][y1]);
        }

        //左
        if (y0 != y1) {
            for (int i = y1 - 1; i >= y0; i--) {
                res.add(matrix[x1][i]);
            }
        }

        //上
        if (x0 != x1) {
            for (int i = x1 - 1; i >= x0 + 1; i--) {
                res.add(matrix[i][y0]);
            }
        }
        search(step + 1, matrix, height, width, res);
    }

    public static void main(String[] args) {
        int[][] a = new int[3][4];
        int count = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = count;
                count++;
            }
        }
        new Solution29().spiralOrder(a);
    }


}