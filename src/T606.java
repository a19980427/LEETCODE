
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    StringBuilder res;

    public String tree2str(TreeNode root) {
        res = new StringBuilder();
        search(root);
        return res.toString();
    }

    void search(TreeNode root) {
        if (root == null) {
            return;
        }
        res.append(root.val);
        if (root.left != null) {
            res.append("(");
            search(root.left);
            res.append(")");
        }
        if (root.right != null) {
            if (root.left == null) {
                res.append("()");
            }
            res.append("(");
            search(root.right);
            res.append(")");
        }
    }
}