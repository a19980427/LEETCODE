package 剑指offer;

import TempClass.TreeNode;

/**
 * @author qihang
 * @create 2022-08-28 下午  06:02
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        build(root);
        return root;
    }

    void build(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        build(root.left);
        build(root.right);

    }
}
