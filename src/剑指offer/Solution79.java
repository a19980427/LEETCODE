package 剑指offer;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author qihang
 * @create 2022-08-18 上午  11:52
 */
public class Solution79 {

    private int width;
    private int height;
    private boolean[][] visited;
    private char[][] board;

    private static final int[] xMove = {-1, 1, 0, 0};
    private static final int[] yMove = {0, 0, -1, 1};

    private void init(char[][] board) {
        this.width = board[0].length;
        this.height = board.length;
        this.board = board;
        this.visited = new boolean[height][width];
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
    }

    public boolean exist(char[][] board, String word) {
        if (Objects.isNull(board) || board.length == 0) {
            return false;
        }
        init(board);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                visited[i][j] = true;
                boolean find = search(word, 0, i, j);
                if (find) {
                    return true;
                }
                visited[i][j] = false;
            }
        }
        return false;
    }


    public boolean search(String word, int index, int i, int j) {
        if (word.length() == index) {
            return true;
        }
        char c = word.charAt(index);
        if (!outOfIndex(i, j)) {
            char boardChar = board[i][j];
            if (boardChar == c) {
                if (index == word.length() -1 ){
                    return true;
                }
                visited[i][j] = true;
                boolean find = false;
                for (int k = 0; k < 4; k++) {
                    int tempJ = j + xMove[k];
                    int tempI = i + yMove[k];
                    if (!outOfIndex(tempI, tempJ) && !visited[tempI][tempJ]) {
                        find = search(word, index + 1, tempI, tempJ);
                        if (find) {
                            return true;
                        }
                    }
                }
                visited[i][j] = false;
            }
        }
        return false;
    }

    public boolean outOfIndex(int i, int j) {
        return i < 0 || i >= height || j < 0 || j >= width;
    }

    public static void main(String[] args) {
        String key = "A";
        char[][] board = {
                {'A'},
        };
        new Solution79().exist(board, key);
    }
}
