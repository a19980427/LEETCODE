package 剑指offer;

import java.util.Arrays;

/**
 * @Author: qihang
 * @Date: 2022/07/02/上午  11:02
 * @Description:
 */
public class Solution12 {
    class Solution {

        private int width;
        private int height;

        private char[][] board;

        private String word;

        private final int[][] op = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        private boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0) {
                return false;
            }
            if (word == null || word.length() == 0) {
                return true;
            }
            this.width = board.length;
            this.height = board[0].length;
            this.word = word;
            this.board = board;
            this.visited = new boolean[width][height];

            char startChar = word.charAt(0);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (board[i][j] != startChar) {
                        continue;
                    }
                    for (boolean[] booleans : visited) {
                        Arrays.fill(booleans, false);
                    }
                    if (search(0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean search(int index, int x, int y) {
            if (index >= word.length()) {
                return true;
            }
            if (checkIndex(x, y) && !visited[x][y]) {
                char ch = word.charAt(index);
                char boardCh = board[x][y];

                if (ch == boardCh) {
                    visited[x][y] = true;
                    for (int[] ints : op) {
                        if (search(index + 1, x + ints[0], y + ints[1])) {
                            return true;
                        }
                    }
                    visited[x][y] = false;
                }
            }
            return false;
        }

        public boolean checkIndex(int x, int y) {
            return x >= 0 && y >= 0 && x < width && y < height;
        }
    }

    public static void main(String[] args) {
        boolean res = new Solution12().new Solution().exist(
                new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                "ABCCED");
        System.out.println(res);
    }
}
