package 剑指offer;

import TempClass.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: qihang
 * @Date: 2022/06/30/上午  11:16
 * @Description:
 */
public class Solution07 {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            List<Integer> pre = Arrays.stream(preorder).boxed().collect(Collectors.toList());
            List<Integer> in = Arrays.stream(inorder).boxed().collect(Collectors.toList());

            if (preorder.length == 0) {
                return null;
            }

            TreeNode root = new TreeNode(0);
            build(root, pre, in);
            return root;
        }


        private TreeNode build(TreeNode root, List<Integer> pre, List<Integer> in) {
            if (in.size() == 0 || pre.size() == 0) {
                return null;
            }

            Integer rootVal = pre.get(0);
            root.val = rootVal;

            if (pre.size() > 1 && in.size() > 1) {
                //在中序遍历中找根节点下标
                int inRootIndex = in.indexOf(rootVal);
                List<Integer> inLeft = in.subList(0, inRootIndex);
                List<Integer> inRight = in.subList(inRootIndex + 1, in.size());

                List<Integer> preLeft = null;
                List<Integer> preRight = null;
                if (inRight.size() == 0) { //没有右子树
                    preLeft = pre.subList(1, pre.size());
                    root.left = build(new TreeNode(0), preLeft, inLeft);
                    root.right = null;
                } else if (inLeft.size() == 0) { //没有左子树
                    preRight = pre.subList(1, pre.size());
                    root.right = build(new TreeNode(0), preRight, inRight);
                    root.left = null;
                } else { //左右子树都存在
                    //在先序遍历中找右子树下标
                    int preRightIndex = findPreRightIndex(pre, inRight);
                    preLeft = pre.subList(1, preRightIndex);
                    preRight = pre.subList(preRightIndex, pre.size());

                    root.left = build(new TreeNode(0), preLeft, inLeft);
                    root.right = build(new TreeNode(0), preRight, inRight);
                }
            }
            return root;
        }

        private int findPreRightIndex(List<Integer> pre, List<Integer> inRight) {
            return inRight.stream().map(pre::indexOf).min(Integer::compare).orElse(-1);
        }

    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        final Solution solution = new Solution07().new Solution();
        solution.buildTree(preorder, inorder);
    }
}
