import java.util.ArrayList;

/**
 * @author qihang
 * @create 2022-09-16 下午  05:03
 */
public class Solution538 {
    int index = 0;
    private ArrayList<TreeNode> arrayList = new ArrayList();
    private int[] dp;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        search(root);
        int size = arrayList.size();
        dp = new int[size];
        dp[size - 1] = arrayList.get(size - 1).val;
        for (int i = size - 2; i >= 0; i--) {
            dp[i] = arrayList.get(i).val + dp[i + 1];
        }
        for (int i : dp) {
            System.out.println(i);
        }
        System.out.println("--" + root.left + "," + root.right);
        setValue(root);
        return root;
    }

    void search(TreeNode root) {
        if (root == null) {
            return;
        }
        search(root.left);
        arrayList.add(root);
        search(root.right);
    }

    void setValue(TreeNode root) {
        if (root == null) {
            return;
        }
        setValue(root.left);
        System.out.println("root : " + root.val + " index : " + index + " : " + dp[index]);
        root.val = dp[index++];
        setValue(root.right);
    }
}
