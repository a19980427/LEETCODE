import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qihang
 * @create 2022-09-05 下午  12:25
 */
public class Solution652 {
    private Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        search(root);
        return res;
    }

    private String search(TreeNode root) {
        if (root == null) {
            return "#";
        } else {
            StringBuilder sb = new StringBuilder();
            StringBuilder router = sb.append(root.val + " ").append(search(root.left)).append(search(root.right));

            Integer count = map.getOrDefault(router.toString(), 0);
            if (count == 1) {
                res.add(root);
            }
            map.put(router.toString(), count + 1);
            return sb.toString();
        }
    }
}