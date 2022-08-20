import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution954 {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int cnt = map.getOrDefault(i, 0);
            map.put(i, cnt + 1);
        }
        for (int i : arr) {
            int cnt = map.getOrDefault(i, 0);
            if (cnt > 0) {
                int doubleCnt = map.getOrDefault(i * 2, 0);
                if (doubleCnt > 0) {
                    map.put(i, cnt - 1);
                    map.put(i * 2, doubleCnt - 1);
                }
            }
        }
        final List<Integer> collect = new ArrayList<>(map.values());
        for (Integer integer : collect) {
            if (integer != 0) {
                return false;
            }
        }
        return true;
    }
}