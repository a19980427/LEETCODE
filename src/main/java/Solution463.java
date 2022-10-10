/**
 * @author qihang
 * @create 2022-10-10 下午  01:21
 */
public class Solution463 {
    class Solution {

        int height;
        int width;
        int[][] grid;

        private int[][] ops = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int islandPerimeter(int[][] grid) {
            this.height = grid.length;
            this.width = grid[0].length;
            this.grid = grid;

            int res = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (grid[i][j] == 1) {
                        res += compute(i, j);
                    }
                }
            }
            return res;
        }

        private int compute(int x, int y) {
            int count = 0;
            for (int[] op : ops) {
                count += getEdge(x + op[0], y + op[1]);
            }
            return count;
        }

        private int getEdge(int x, int y) {
            if (outOfBound(x, y)) {
                return 1;
            }
            return grid[x][y] == 1 ? 0 : 1;
        }

        private boolean outOfBound(int x, int y) {
            return (x < 0 || x >= height || y < 0 || y >= width);
        }
    }
}
