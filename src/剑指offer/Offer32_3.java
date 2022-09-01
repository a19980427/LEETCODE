package 剑指offer;

import TempClass.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author qihang
 * @create 2022-09-01 下午  12:28
 */
public class Offer32_3 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        search(root, 0);
        for (int i = 0; i < res.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(res.get(i));
            }
        }
        return res;
    }

    private void search(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        search(root.left, depth + 1);
        search(root.right, depth + 1);
    }
}
