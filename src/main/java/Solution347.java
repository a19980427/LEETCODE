import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author qihang
 * @create 2022-10-13 上午  11:24
 */
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        PriorityQueue<Entry<Integer, Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> o2.getValue() - o1.getValue());

        queue.addAll(map.entrySet());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.remove().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;

        new Solution347().topKFrequent(arr, k);

    }
}
