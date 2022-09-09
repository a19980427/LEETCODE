package 剑指offer;

import TempClass.TreeNode;

/**
 * @author qihang
 * @create 2022-09-09 上午  11:03
 */
public class Offer55 {
    private boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {
        getDepth(root, 0);
        return isBalance;
    }

    private int getDepth(TreeNode root, int depth) {
        if (root == null || !isBalance) {
            return 0;
        }
        int leftDepth = getDepth(root.left, depth + 1);
        int rightDepth = getDepth(root.right, depth + 1);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            this.isBalance = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
