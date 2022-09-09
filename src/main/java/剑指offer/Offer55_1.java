package 剑指offer;

import TempClass.TreeNode;

/**
 * @author qihang
 * @create 2022-09-09 上午  11:58
 */
public class Offer55_1 {
    public int maxDepth(TreeNode root) {
        return search(root, 0);
    }

    private int search(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }
        return Math.max(search(root.left, depth + 1), search(root.right, depth + 1)) + 1;
    }
}
