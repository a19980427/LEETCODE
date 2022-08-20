import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Solution429 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> levelOrder(Node root) {
        search(root, 1);
        return res;
    }
    void search(Node root, int deepth) {
        if (root == null) {
            return;
        }
        if (res.size() < deepth) {
            res.add(new LinkedList<>());
        }
        res.get(deepth - 1).add(root.val);
        for (Node child : root.children) {
            search(child, deepth + 1);
        }
    }
}