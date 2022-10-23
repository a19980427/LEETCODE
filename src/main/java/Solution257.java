import java.util.ArrayList;
import java.util.List;

/**
 * @author qihang
 * @create 2022-10-23 下午  09:58
 */
public class Solution257 {

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        search(root, new StringBuilder());
        return res;
    }

    private void search(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            res.add(String.valueOf(stringBuilder) + root.val);
            return;
        }

        int originLength = stringBuilder.length();
        stringBuilder.append(root.val).append("->");
        search(root.left, stringBuilder);
        search(root.right, stringBuilder);
        stringBuilder.delete(originLength, stringBuilder.length());
    }
}
