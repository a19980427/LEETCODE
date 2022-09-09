package 剑指offer;

import TempClass.TreeNode;

/**
 * @author qihang
 * @create 2022-09-09 下午  12:01
 */
public class Offer68 {

    TreeNode ancestor = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode minNode = p.val < q.val ? p : q;
        TreeNode maxNode = p.val > q.val ? p : q;
        search(root, minNode, maxNode);
        return ancestor;
    }

    public void search(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        if (root.val == minNode.val || root.val == maxNode.val) {
            ancestor = root;
        } else if (root.val > maxNode.val) {
            search(root.left, minNode, maxNode);
        } else if (root.val < minNode.val) {
            search(root.right, minNode, maxNode);
        } else {
            ancestor = root;
        }
    }
}
