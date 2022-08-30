package 剑指offer;

import TempClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author qihang
 * @create 2022-08-29 上午  10:21
 */
public class Offer32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<TreeNode> res = new ArrayList<>();

        queue.add(root);

        while (queue.size() != 0) {
            TreeNode treeNode = queue.remove();
            res.add(treeNode);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return res.stream().map(item -> item.val).mapToInt(Integer::intValue).toArray();
    }
}
