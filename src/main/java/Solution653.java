import java.util.ArrayList;

public class Solution653 {

    ArrayList<Integer> sortedArrays;

    public boolean findTarget(TreeNode root, int k) {
        sortedArrays = new ArrayList<>();
        search(root);

        int left = 0;
        int right = sortedArrays.size() - 1;

        while (sortedArrays.get(right) > k) {
            right -= 1;
        }

        System.out.println(sortedArrays);

        while (left < right) {
            if (sortedArrays.get(left) + sortedArrays.get(right) == k) {
                return true;
            }
            if (sortedArrays.get(left) + sortedArrays.get(right) < k) {
                return false;
            }
            // >k
            int leftGap = sortedArrays.get(left + 1) - sortedArrays.get(left);
            int rightGap = sortedArrays.get(right - 1) - sortedArrays.get(right);

            if (leftGap < rightGap) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return false;
    }

    void search(TreeNode root) {
        if (root != null) {
            sortedArrays.add(root.val);
            search(root.left);
            search(root.right);
        }
    }


    public static void main(String[] args) {

    }
}
