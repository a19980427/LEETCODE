package 剑指offer;

import TempClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qihang
 * @create 2022-09-05 下午  02:05
 */
public class Offer34 {
    List<List<Integer>> res = new ArrayList<>();

    private int target;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.target = target;
        search(root, new ArrayList<>(), 0);
        return res;
    }

    private void search(TreeNode root, List<Integer> parentList, int parentSum) {
        if (root == null) {
            return;
        }
        List<Integer> list = new ArrayList<>(parentList);
        list.add(root.val);

        if (root.left == null && root.right == null) {
            if (root.val + parentSum == target) {
                res.add(list);
            }
        } else {
            search(root.left, list, root.val + parentSum);
            search(root.right, list, root.val + parentSum);
        }
    }
}

