import java.util.ArrayList;
import java.util.List;

/**
 * @author qihang
 * @create 2022-10-07 下午  01:30
 */
public class Solution199 {
    ArrayList<ArrayList<TreeNode>> arrayList = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        search(root, 1);
        ArrayList<Integer> res = new ArrayList<>();
        for (ArrayList<TreeNode> treeNodes : arrayList) {
            res.add(treeNodes.get(treeNodes.size() - 1).val);
        }
        return res;
    }


    private void search(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > arrayList.size()) {
            arrayList.add(new ArrayList<>());
        }
        arrayList.get(depth - 1).add(root);
        search(root.left, depth + 1);
        search(root.right, depth + 1);
    }
}
