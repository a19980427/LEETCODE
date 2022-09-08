package 剑指offer;

/**
 * @author qihang
 * @create 2022-08-22 上午  01:03
 */
public class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp = 0;
        //沿对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //左右翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}