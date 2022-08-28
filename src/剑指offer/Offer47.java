package 剑指offer;

/**
 * @author qihang
 * @create 2022-08-27 下午  08:55
 */
public class Offer47 {
    private int height;
    private int width;

    public int maxValue(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        height = grid.length;
        width = grid[0].length;

        int[][] dp = new int[height][width];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                dp[i][j] = Math.max(getValue(dp, i - 1, j), getValue(dp, i, j - 1)) + grid[i][j];
            }
        }
        return dp[height - 1][width - 1];
    }

    private int getValue(int[][] dp, int x, int y) {
        if (x < 0 || x > height || y < 0 || y > width) {
            return 0;
        }
        return dp[x][y];
    }
}
