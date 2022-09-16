package Hot100;

/**
 * @author qihang
 * @create 2022-09-16 下午  01:07
 */
public class Solution200 {
    private int count = 0;
    private char[][] grid;
    private boolean[][] visited;
    private int x, y;
    private final int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        this.grid = grid;
        x = grid.length;
        y = grid[0].length;
        visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (visitAble(i, j)) {
                    search(i, j);
                    ++count;
                }
            }
        }

        return count;
    }

    private void search(int i, int j) {
        if (!visitAble(i, j)) {
            return;
        }
        visited[i][j] = true;
        for (int[] op : move) {
            search(i + op[0], j + op[1]);
        }
    }

    private boolean visitAble(int i, int j) {
        return (i >= 0 && i < x) && (j >= 0 && j < y) && !visited[i][j] && grid[i][j] == '1';
    }

}
