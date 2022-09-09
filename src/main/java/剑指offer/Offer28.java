package 剑指offer;

import TempClass.TreeNode;

/**
 * @author qihang
 * @create 2022-09-09 上午  11:29
 */
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return search(root.left, root.right);
    }

    public boolean search(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left != null && right == null) || (left == null && right != null)) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return search(left.right, right.left) && search(left.left, right.right);
    }
}
