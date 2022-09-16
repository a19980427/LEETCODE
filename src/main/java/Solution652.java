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

    static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int base = arr[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && arr[j] >= base) {
                j--;
            }
            while (i < j && arr[i] <= base) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, start, i);
        quickSort(arr, start, j - 1);
        quickSort(arr, j + 1, end);

    }

    static void swap(int[] arr, int l1, int l2) {
        int temp = arr[l1];
        arr[l1] = arr[l2];
        arr[l2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 2, 34, 2, 1, 3, 4};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
