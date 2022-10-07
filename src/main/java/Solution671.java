import java.util.TreeSet;

/**
 * @author qihang
 * @create 2022-10-06 下午  08:05
 */
public class Solution671 {
    public int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        search(set, root);
        if (set.size() == 1) {
            return -1;
        }
        set.pollFirst();
        return set.pollFirst();

    }

    void search(TreeSet<Integer> set, TreeNode root) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        search(set, root.left);
        search(set, root.right);
    }
}
