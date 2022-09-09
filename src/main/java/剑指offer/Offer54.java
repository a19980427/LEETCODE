package 剑指offer;

import TempClass.TreeNode;

/**
 * @author qihang
 * @create 2022-09-09 上午  11:21
 */
public class Offer54 {
    private int count = 0;
    private int k;
    private int res;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        search(root);
        return res;
    }

    private void search(TreeNode root) {
        if (root == null || count > k) {
            return;
        }
        search(root.right);
        count += 1;
        if (count == k) {
            res = root.val;
        }
        search(root.left);
    }
}
