package 剑指offer;


/**
 * @author qihang
 * @create 2022-09-05 下午  01:25
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class Offer36 {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        search(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void search(Node root) {
        if (root == null) {
            return;
        }
        search(root.left);
        if (pre == null) {
            head = root;
        } else {
            root.left = pre;
            pre.right = root;
        }
        pre = root;
        search(root.right);
    }
}