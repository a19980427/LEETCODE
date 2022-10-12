/**
 * @author qihang
 * @create 2022-10-11 下午  04:31
 */
public class Solution98 {
    long pre;

    public boolean isValidBST(TreeNode root) {
        pre = Long.MIN_VALUE;
        return search(root);
    }


    private boolean search(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!search(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return search(root.right);
    }
}
